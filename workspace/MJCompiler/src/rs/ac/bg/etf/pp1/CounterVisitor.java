package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;

public class CounterVisitor extends VisitorAdaptor {

	protected int count = 0;
	
	public int getCount(){
		return count;
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(SingleVarDecl singleVarDecl){
			count++;
		}
	}
}
