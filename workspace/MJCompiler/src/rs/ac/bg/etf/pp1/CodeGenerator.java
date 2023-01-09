package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.ac.bg.etf.pp1.extendedsymboltable.Tab;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(PrintStmt printStmt) {
		if (printStmt.getPrintArgs() instanceof PrintArgsNoEmpty) {
			Code.loadConst(((PrintArgsNoEmpty) printStmt.getPrintArgs()).getValue());
		} else {
			Code.loadConst(5);
		}
		if (printStmt.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}
	
	public void visit(FactorNum factorNum) {
		Code.loadConst(factorNum.getValue());
	}
	
	public void visit(FactorBool factorBool) {
		Code.loadConst(factorBool.getValue() ? 1 : 0);
	}
	
	public void visit(FactorChar factorChar) {
		Code.loadConst(factorChar.getValue());
	}
	
	// Works only for main method
	public void visit(MethodNameIdent methodNameIdent) {
		if ("main".equalsIgnoreCase(methodNameIdent.getMethName())) {
			mainPc = Code.pc;
		}
		methodNameIdent.obj.setAdr(Code.pc);
		
		SyntaxNode methodNode = methodNameIdent.getParent();
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		Code.put(Code.enter);
		Code.put(0);
		Code.put(varCnt.getCount());
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(FactorDesignatorEmpty factorDesignatorEmpty) {
		Code.load(factorDesignatorEmpty.getDesignator().obj);
	}

	public void visit(DesignatorAssignStmt designatorAssignStmt) {
		Code.store(designatorAssignStmt.getDesignator().obj);
	}
	
	public void visit(MultipleFactors multipleFactors) {
		Mulop mulop = multipleFactors.getMulop();
		if (mulop instanceof Mul) {
			Code.put(Code.mul);
		} else if (mulop instanceof Div) {
			Code.put(Code.div);
		} else if (mulop instanceof Mod) {
			Code.put(Code.rem);
		}
	}
	
	public void visit(AddopTermExpr addopTermExpr) {
		Addop addop = addopTermExpr.getAddop();
		if (addop instanceof Plus) {
			Code.put(Code.add);
		} else if (addop instanceof Minus) {
			Code.put(Code.sub);
		}
	}
	
	public void visit(OptionalMinusTerm optionalMinusTerm) {
		if (optionalMinusTerm.getOptionalMinus() instanceof WithMinus) {
			Code.put(Code.neg);
		}
	}
	
	public void visit(DesignatorIncStmt designatorIncStmt) {
		Code.load(designatorIncStmt.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorIncStmt.getDesignator().obj);
	}
	
	public void visit(DesignatorDecStmt designatorDecStmt) {
		Code.load(designatorDecStmt.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorDecStmt.getDesignator().obj);
	}
	
	public void visit(FactorNewExpr factorNewExpr) {
		Code.put(Code.newarray);
		if (factorNewExpr.getExpr().struct.equals(Tab.charType)) {
			Code.loadConst(0);
		} else {
			Code.loadConst(1);
		}
	}
	
	public void visit(ArrayDesig arrayDesig) {
		Code.load(arrayDesig.getDesignator().obj);
	}
	
	public void visit(ReadStmt readStmt) {
		if (readStmt.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(readStmt.getDesignator().obj);
	}
}
