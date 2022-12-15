package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

public class Compiler {
	
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJParser.class);
		if (args.length < 1) {
			log.error("Not enough arguments supplied! Usage: MJCompiler <source-file> ");
			return;
		}
		
		File sourceCode = new File(args[0]);
		if (!sourceCode.exists()) {
			log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
			return;
		}
			
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();
	        SyntaxNode prog = (SyntaxNode)(s.value);
	        log.info("================Ispis sintaksnog stabla================");
	        log.info("\n" + prog.toString());
	        log.info("=======================================================");
	        
	        
	        log.info("==================SEMANTICKA OBRADA====================");
	        
	        log.info("==================SINTAKSNA ANALIZA====================");
	        RuleVisitor v = new RuleVisitor();
			prog.traverseBottomUp(v); 

			log.info(v.classCount + "\tclasses");
			log.info(v.methodCount + "\tmethods in the program");
			log.info(v.globalVarCount + "\tglobal variables");
			log.info(v.globalConstCount + "\tglobal constants");
			log.info(v.globalArrCount + "\tglobal arrays");
			log.info(v.localVarInMainCount + "\tlocal variables in main");
			log.info(v.stmtInMainCount + "\tstatements in main");
			log.info(v.funcCallsInMainCount + "\tfunction calls in main");
			
	        log.info("==============SADRZAJ TABELE SIMBOLA===================");
		}
	}
}
