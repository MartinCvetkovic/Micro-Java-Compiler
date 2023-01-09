package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.extendedsymboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int constCount = 0;
	int globalVarCount = 0;
	int localVarCount = 0;
	boolean errorDetected = false;
	Struct currentType = null;
	int currentConstantValue;
	boolean constantTypeError;
	Obj currentMethod;
	boolean mainExists = false;
	int nVars;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info, Obj objNode) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		DumpSymbolTableVisitor printer = new DumpSymbolTableVisitor();
		printer.visitObjNode(objNode);
		msg.append(", objektni cvor: " + printer.getOutput());
		log.info(msg.toString());
	}

	public boolean passed() {
		return !errorDetected;
	}
	
	public void mainMethCheck() {
		if (!mainExists) {
			report_error("Metoda void main() ne postoji", null);
		}
	}

	public void visit(PProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgName(), new Struct(Struct.None));
		Tab.openScope();
	}

	public void visit(PProgram pprogram) {
		nVars = Tab.currentScope().getnVars();
		Tab.chainLocalSymbols(pprogram.getProgramName().obj);
		Tab.closeScope();
	}

	public void visit(TypeIdent type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
			type.struct = Tab.noType;
			currentType = null;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				currentType = typeNode.getType();
			} else {
				report_error("Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
				currentType = null;
			}
		}
	}

	public void visit(SingleVarDeclaration singleVarDeclaration) {
		if (currentType == null) {
			return;
		}
		if (Tab.currentScope().findSymbol(singleVarDeclaration.getVarName()) != null) {
			report_error("Promenljiva " + singleVarDeclaration.getVarName() + " vec deklarisana u opsegu", singleVarDeclaration);
			return;
		}
		singleVarDeclaration.obj = Tab.insert(Obj.Var, singleVarDeclaration.getVarName(), currentType);
		report_info("Deklarisana promenljiva " + singleVarDeclaration.getVarName(), singleVarDeclaration, singleVarDeclaration.obj);
		if (singleVarDeclaration.obj.getLevel() == 0) {
			globalVarCount++;
		} else {
			localVarCount++;
		}
	}

	public void visit(SingleVarArrayDecl singleVarArrayDecl) {
		if (currentType == null) {
			return;
		}
		if (Tab.currentScope().findSymbol(singleVarArrayDecl.getVarName()) != null) {
			report_error("Promenljiva " + singleVarArrayDecl.getVarName() + " ponovo deklarisana", singleVarArrayDecl);
			return;
		}
		Struct arr = new Struct(Struct.Array);
		arr.setElementType(currentType);
		singleVarArrayDecl.obj = Tab.insert(Obj.Var, singleVarArrayDecl.getVarName(), arr);
		report_info("Deklarisana promenljiva " + singleVarArrayDecl.getVarName(), singleVarArrayDecl, singleVarArrayDecl.obj);
		if (singleVarArrayDecl.obj.getLevel() == 0) {
			globalVarCount++;
		} else {
			localVarCount++;
		}
	}
	
	public void visit(ConstantAssign constantAssign) {
		if (currentType == null) {
			return;
		}
		if (constantTypeError) {
			constantTypeError = false;
			report_error("Pogresan tip vrednosti koja se dodeljuje konstanti " + constantAssign.getConstName(), constantAssign);
			return;
		}
		if (Tab.currentScope().findSymbol(constantAssign.getConstName()) != null) {
			report_error("Konstanta " + constantAssign.getConstName() + " ponovo deklarisana", constantAssign);
			return;
		}
		constantAssign.obj = Tab.insert(Obj.Con, constantAssign.getConstName(), currentType);
		constantAssign.obj.setAdr(currentConstantValue);
		report_info("Deklarisana konstanta " + constantAssign.getConstName(), constantAssign, constantAssign.obj);
		constCount++;
	}

	public void visit(NumConst numConst) {
		currentConstantValue = numConst.getNumVal();
		if (!Tab.intType.equals(currentType)) {
			constantTypeError = true;
		}
	}

	public void visit(CharConst charConst) {
		currentConstantValue = (int) charConst.getCharVal();
		if (!Tab.charType.equals(currentType)) {
			constantTypeError = true;
		}
	}

	public void visit(BoolConst boolConst) {
		currentConstantValue = boolConst.getBoolVal() ? 1 : 0;
		if (!Tab.boolType.equals(currentType)) {
			constantTypeError = true;
		}
	}
	
	public void visit(MethodDeclReturnVoid methodDeclReturnVoid) {
		currentType = Tab.noType;
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
    	Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
    	currentMethod = null;
	}
	
	public void visit(MethodNameIdent methodNameIdent) {
		currentMethod = Tab.insert(Obj.Meth, methodNameIdent.getMethName(), currentType);
		methodNameIdent.obj = currentMethod;
    	Tab.openScope();
		report_info("Deklarisana funkcija " + methodNameIdent.getMethName(), methodNameIdent, methodNameIdent.obj);
		if (methodNameIdent.getMethName().equals("main") && methodNameIdent.obj.getLevel() == 0 && currentType == Tab.noType) {
			mainExists = true;
		}
	}
	
	public void visit(DesignatorIdent designatorIdent) {
    	Obj obj = Tab.find(designatorIdent.getName());
    	if(obj.equals(Tab.noObj)){
			report_error("Ime " + designatorIdent.getName() + " nije deklarisano", designatorIdent);
    	}
    	designatorIdent.obj = obj;
	}
	
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	public void visit(FactorBool factorBool) {
		factorBool.struct = Tab.boolType;
	}
	
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	public void visit(FactorDesignatorEmpty factorDesignatorEmpty) {
		if (factorDesignatorEmpty.getDesignator().obj == null) {
			factorDesignatorEmpty.struct = Tab.noType;
			return;
		}
		factorDesignatorEmpty.struct = factorDesignatorEmpty.getDesignator().obj.getType();
	}
	
	public void visit(FactorExpr factorExpr) {
		if (factorExpr.getExpr().struct == Tab.noType) {
			factorExpr.struct = Tab.noType;
			return;
		}
		factorExpr.struct = factorExpr.getExpr().struct;
	}
	
	public void visit(FactorNewExpr factorNewExpr) {
		if (!factorNewExpr.getExpr().struct.equals(Tab.intType)) {
			report_error("Izraz izmedju zagrada prilikom alokacije mora biti tipa int", factorNewExpr);
			factorNewExpr.struct = Tab.noType;
			return;
		}
		factorNewExpr.struct = new Struct(Struct.Array);
		factorNewExpr.struct.setElementType(currentType);
	}
	
	public void visit(SingleFactor singleFactor) {
		singleFactor.struct = singleFactor.getFactor().struct;
	}
	
	public void visit(MultipleFactors multipleFactors) {
		Struct lstruct, rstruct;
		lstruct = multipleFactors.getTerm().struct;
		rstruct = multipleFactors.getFactor().struct;
		if (lstruct.equals(rstruct) && lstruct.equals(Tab.intType)) {
			multipleFactors.struct = lstruct;
			return;
		}
		report_error("Operacije (*, /, %) su moguce samo izmedju int tipova", multipleFactors);
		multipleFactors.struct = Tab.noType;
	}
	
	public void visit(PosExpr posExpr) {
		Struct lstruct, rstruct;
		OptionalMinusTerm optionalMinusTerm = ((OptionalMinusTerm) posExpr.getOptMinusTerm());
		lstruct = optionalMinusTerm.getTerm().struct;
		rstruct = posExpr.getAddopTermList().struct;
		if ((optionalMinusTerm.getOptionalMinus() instanceof WithMinus) && !lstruct.equals(Tab.intType)) {
			report_error("Izraz mora biti int tipa", posExpr);
			posExpr.struct = Tab.noType;
			return;
		}
		if (!(posExpr.getAddopTermList() instanceof EmptyAddopTermList)
				&& (!lstruct.equals(Tab.intType) || !rstruct.equals(Tab.intType))
		) {
			//report_error("Izraz mora biti int tipa", posExpr);
			posExpr.struct = Tab.noType;
			return;
		}
		posExpr.struct = lstruct;
	}
	
	public void visit(NoEmptyAddopTermList noEmptyAddopTermList) {
		Struct lstruct = ((AddopTermExpr) noEmptyAddopTermList.getAddopTerm()).struct;
		if (!lstruct.equals(Tab.intType)) {
			report_error("Operacije sabiranja i oduzimanja su moguce samo izmedju int tipova", noEmptyAddopTermList);
			noEmptyAddopTermList.struct = Tab.noType;
			return;
		}
		noEmptyAddopTermList.struct = lstruct;
	}
	
	public void visit(AddopTermExpr addopTermExpr) {
		addopTermExpr.struct = addopTermExpr.getTerm().struct;
	}
	
	public void visit(DesignatorAssignStmt designatorAssignStmt) {
    	Obj designatorObj = designatorAssignStmt.getDesignator().obj;
    	if (designatorAssignStmt.getDesignator().obj == null || designatorObj.equals(Tab.noObj) || designatorObj.getType().getKind() == Struct.None) {
    		return;
    	}
    	if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Nemoguca dodela vrednosti nepromenljivoj " + designatorObj.getName(), designatorAssignStmt);
			return;
    	}
    	if (!designatorObj.getType().equals(designatorAssignStmt.getExpr().struct)) {
			report_error("Nekompatibilni tipovi prilikom dodele vrednosti promenljivoj", designatorAssignStmt);
			return;
    	}
	}
	
	public void visit(DesignatorArr designatorArr) {
    	Obj designatorObj = Tab.find(((ArrayDesig)designatorArr.getArrayDesignator()).getDesignator().obj.getName());
    	if (designatorObj.equals(Tab.noObj)) {
			designatorArr.obj = Tab.noObj;
    		return;
    	}
    	if (designatorObj.getType().getKind() != Struct.Array) {
			report_error("Simbol " + designatorObj.getName() + " nije niz", designatorArr);
			designatorArr.obj = Tab.noObj;
    		return;
    	}
    	if (!designatorArr.getExpr().struct.equals(Tab.intType)) {
			report_error("Indeks niza mora biti int tipa", designatorArr);
			designatorArr.obj = Tab.noObj;
    		return;
    	}
    	designatorArr.obj = new Obj(Obj.Elem, designatorObj.getName(), designatorObj.getType().getElemType());
	}
	
	public void visit(DesignatorIncStmt designatorIncStmt) {
		Obj designatorObj = designatorIncStmt.getDesignator().obj;
    	if (designatorIncStmt.getDesignator().obj == null || designatorObj.equals(Tab.noObj) || designatorObj.getType().getKind() == Struct.None) {
    		return;
    	}
    	if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Nemoguce inkrementirati nepromenljivu " + designatorObj.getName(), designatorIncStmt);
			return;
    	}
    	if (!designatorObj.getType().equals(Tab.intType)) {
			report_error("Inkrementiranje je moguce samo za tip int", designatorIncStmt);
			return;
    	}
	}
	
	public void visit(DesignatorDecStmt designatorDecStmt) {
		Obj designatorObj = designatorDecStmt.getDesignator().obj;
    	if (designatorDecStmt.getDesignator().obj == null || designatorObj.equals(Tab.noObj) || designatorObj.getType().getKind() == Struct.None) {
    		return;
    	}
    	if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Nemoguce dekrementirati nepromenljivu " + designatorObj.getName(), designatorDecStmt);
			return;
    	}
    	if (!designatorObj.getType().equals(Tab.intType)) {
			report_error("Dekrementiranje je moguce samo za tip int", designatorDecStmt);
			return;
    	}
	}
	
	public void visit(ReadStmt readStmt) {
		Obj designatorObj = readStmt.getDesignator().obj;
    	if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Nemoguce ucitati vrednost u nepromenljivu " + designatorObj.getName(), readStmt);
			return;
    	}
    	if (
    		!designatorObj.getType().equals(Tab.intType)
    		&& !designatorObj.getType().equals(Tab.charType)
    		&& !designatorObj.getType().equals(Tab.boolType)
    	) {
			report_error("Promenljiva u koju se ucitava mora biti int, char ili bool tipa", readStmt);
			return;
    	}
	}
	
	public void visit(PrintStmt printStmt) {
		Struct exprType = printStmt.getExpr().struct;
    	if (
    		!exprType.equals(Tab.intType)
    		&& !exprType.equals(Tab.charType)
    		&& !exprType.equals(Tab.boolType)
    	) {
			report_error("Promenljiva koja se ispisuje mora biti int, char ili bool tipa", printStmt);
			return;
    	}
	}
	
	public void visit(MultipleDesignatorAssignStmt multipleDesignatorAssignStmt) {
    	Obj designatorObj = multipleDesignatorAssignStmt.getDesignator().obj;
    	Obj optionalDesignator = multipleDesignatorAssignStmt.getOptionalDesignator().obj;
    	Obj designatorList = multipleDesignatorAssignStmt.getDesignatorList().obj;
    	if (designatorObj == null || designatorObj.equals(Tab.noObj) || designatorObj.getType().getKind() == Struct.None) {
    		return;
    	}
    	if (designatorObj.getType().getKind() != Struct.Array) {
			report_error("Promenljiva sa desne strane multi dodele mora biti niz", multipleDesignatorAssignStmt);
			return;
    	}
    	Obj resultNode = checkOptionalDesignatorAndDesignatorList(optionalDesignator, designatorList, multipleDesignatorAssignStmt);
    	if (resultNode == null) {
			return;
    	}
    	if (!resultNode.getType().equals(designatorObj.getType().getElemType())) {
			report_error("Nekompatibilni tipovi izraza sa leve i desne strane multi dodele", multipleDesignatorAssignStmt);
			return;
    	}
	}
	
	public void visit(OptionalDesignatorExists optionalDesignatorExists) {
		optionalDesignatorExists.obj = optionalDesignatorExists.getDesignator().obj;
	}
	
	public void visit(NoEmptyDesignatorList noEmptyDesignatorList) {
		Obj optionalDesignator = noEmptyDesignatorList.getOptionalDesignator().obj;
		Obj designatorList = noEmptyDesignatorList.getDesignatorList().obj;
		noEmptyDesignatorList.obj = checkOptionalDesignatorAndDesignatorList(optionalDesignator, designatorList, noEmptyDesignatorList);
	}
	
	private Obj checkOptionalDesignatorAndDesignatorList(Obj optionalDesignator, Obj designatorList, SyntaxNode syntaxNode) {
		Struct tempStruct = null;
		if (optionalDesignator != null) {
			if (optionalDesignator.getKind() != Obj.Var && optionalDesignator.getKind() != Obj.Elem) {
				report_error("Nemoguca dodela vrednosti nepromenljivoj", syntaxNode);
				return null;
			}
			tempStruct = optionalDesignator.getType();
		}
		if (designatorList != null) {
			if (designatorList.getKind() != Obj.Var && designatorList.getKind() != Obj.Elem) {
				report_error("Nemoguca dodela vrednosti nepromenljivoj", syntaxNode);
				return null;
			}
			if (tempStruct == null) {
				tempStruct = designatorList.getType();
			} else {
				if (!optionalDesignator.getType().equals(designatorList.getType())) {
					report_error("Nekompatibilni tipovi sa leve strane multi dodele", syntaxNode);
					return null;
				}
			}
		}
		if (tempStruct == null) {
			return null;
		} else {
			return new Obj(Obj.Var, "", tempStruct);
		}
	}
}
