package rs.ac.bg.etf.pp1.extendedsymboltable;

import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class Struct extends rs.etf.pp1.symboltable.concepts.Struct {

	public static final int Bool = 5;

	public Struct(int kind) {
		super(kind);
	}

	public Struct(int kind, rs.etf.pp1.symboltable.concepts.Struct elemType) {
		super(kind, elemType);
	}

	public Struct(int kind, SymbolDataStructure members) {
		super(kind, members);
	}

}
