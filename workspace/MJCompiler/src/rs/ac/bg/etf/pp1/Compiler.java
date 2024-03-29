package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
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
		if (args.length < 2) {
			log.error("Not enough arguments supplied! Usage: MJCompiler <source-file> <object-file>");
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
			MJParser parser = new MJParser(lexer);
	        Symbol s = parser.parse();
	        SyntaxNode prog = (SyntaxNode)(s.value);
	        log.info("================Ispis sintaksnog stabla================");
	        log.info("\n" + prog.toString());
	        
	        log.info("==================SEMANTICKA OBRADA====================");
	        Tab.init();
	        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);
			semanticAnalyzer.mainMethCheck();
			
	        log.info("==================SINTAKSNA ANALIZA====================");
			log.info(semanticAnalyzer.constCount + "\tsymbolic constants");
			log.info(semanticAnalyzer.globalVarCount + "\tglobal variables");
			log.info(semanticAnalyzer.localVarCount + "\tlocal variables");
			
	        //log.info("==============SADRZAJ TABELE SIMBOLA===================");
	        tsdump();
	        
	        if (parser.errorDetected || !semanticAnalyzer.passed()) {
	        	log.info("Parsiranje nije uspesno zavrseno");
	        	return;
	        }
	        
	        File objFile = new File(args[1]);
	        if (objFile.exists()) objFile.delete();
	        
	        CodeGenerator codeGenerator = new CodeGenerator();
	        prog.traverseBottomUp(codeGenerator);
	        Code.dataSize = semanticAnalyzer.nVars;
	        Code.mainPc = codeGenerator.getMainPc();
	        Code.write(new FileOutputStream(objFile));
	        
        	log.info("Parsiranje je uspesno zavrseno");
		}
	}
}
