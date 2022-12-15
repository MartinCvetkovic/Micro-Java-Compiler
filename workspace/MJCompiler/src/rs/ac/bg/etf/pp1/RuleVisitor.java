package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{
	
	int classCount = 0;
	int methodCount = 0;
	int globalVarCount = 0;
	int globalConstCount = 0;
	int globalArrCount = 0;
	int localVarInMainCount = 0;
	int stmtInMainCount = 0;
	int funcCallsInMainCount = 0;
	
	Logger log = Logger.getLogger(getClass());

	public void visit(ClassDeclNameExtend classDeclNameExtend){
		classCount++;
	}

	public void visit(ClassDeclNameNoExtend classDeclNameNoExtend){
		classCount++;
	}

	public void visit(MethodDeclReturnVoid methodDeclReturnVoid){
		methodCount++;
	}

	public void visit(MethodDeclReturnType methodDeclReturnType){
		methodCount++;
	}

}
