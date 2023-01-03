package rs.ac.bg.etf.pp1.extendedsymboltable;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Tab extends rs.etf.pp1.symboltable.Tab {

	public static final Struct boolType = new Struct(Struct.Bool);
	
	/**
	 * Inicijalizacija universe opsega, tj. njegovo popunjavanje Obj cvorovima,
	 * kao sto je izlozeno na vezbama i predavanjima. Razlika je sto se Obj
	 * cvorovu umecu u hes tabelu.
	 */
	public static void init() {
		rs.etf.pp1.symboltable.Tab.init();
        Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
	
	/** Stampa sadrzaj tabele simbola. */
	public static void dump() {
		dump(new DumpSymbolTableVisitor());
	}

}
