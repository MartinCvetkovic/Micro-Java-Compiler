package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.ac.bg.etf.pp1.extendedsymboltable.Tab;

public class Compiler {
	
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void tsdump() {
		Tab.dump();
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
	        
	        Tab.init();
	        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
	        
	        log.info("==================SEMANTICKA OBRADA====================");
			prog.traverseBottomUp(semanticAnalyzer);
			
	        log.info("==================SINTAKSNA ANALIZA====================");
			log.info(semanticAnalyzer.classCount + "\tclasses");
			log.info(semanticAnalyzer.methodCount + "\tmethods in the program");
			log.info(semanticAnalyzer.globalVarCount + "\tglobal variables");
			log.info(semanticAnalyzer.globalConstCount + "\tglobal constants");
			log.info(semanticAnalyzer.globalArrCount + "\tglobal arrays");
			log.info(semanticAnalyzer.localVarInMainCount + "\tlocal variables in main");
			log.info(semanticAnalyzer.stmtInMainCount + "\tstatements in main");
			log.info(semanticAnalyzer.funcCallsInMainCount + "\tfunction calls in main");
			
	        log.info("==============SADRZAJ TABELE SIMBOLA===================");
	        tsdump();
	        
		}
	}
}
