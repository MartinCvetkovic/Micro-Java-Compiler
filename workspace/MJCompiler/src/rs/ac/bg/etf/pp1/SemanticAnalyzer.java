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
			report_error("Promenljiva " + singleVarDeclaration.getVarName() + " ponovo deklarisana", singleVarDeclaration);
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
}
