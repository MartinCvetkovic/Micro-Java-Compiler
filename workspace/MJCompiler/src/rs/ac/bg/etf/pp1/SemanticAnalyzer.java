package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;

import rs.ac.bg.etf.pp1.extendedsymboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

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

	public void visit(PProgram pprogram){
		//Tab.insert(Obj.Prog, pprogram.getProgName(), new Struct(Struct.None));
	}
}
