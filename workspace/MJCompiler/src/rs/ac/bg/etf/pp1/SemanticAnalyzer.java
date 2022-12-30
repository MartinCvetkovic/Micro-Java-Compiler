package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.ClassDeclNameExtend;
import rs.ac.bg.etf.pp1.ast.ClassDeclNameNoExtend;
import rs.ac.bg.etf.pp1.ast.MethodDeclReturnType;
import rs.ac.bg.etf.pp1.ast.MethodDeclReturnVoid;
import rs.ac.bg.etf.pp1.ast.PProgram;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.ac.bg.etf.pp1.extendedsymboltable.*;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	int classCount = 0;
	int methodCount = 0;
	int globalVarCount = 0;
	int globalConstCount = 0;
	int globalArrCount = 0;
	int localVarInMainCount = 0;
	int stmtInMainCount = 0;
	int funcCallsInMainCount = 0;
	boolean errorDetected = false;
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}

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

	public void visit(PProgram pprogram){
		//Tab.insert(Obj.Prog, pprogram.getProgName(), Struct.)
	}

}
