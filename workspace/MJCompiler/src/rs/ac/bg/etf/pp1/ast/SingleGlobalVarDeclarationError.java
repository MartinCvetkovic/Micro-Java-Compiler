// generated with ast extension for cup
// version 0.8
// 16/11/2022 17:58:38


package rs.ac.bg.etf.pp1.ast;

public class SingleGlobalVarDeclarationError extends GlobalVarDecl {

    public SingleGlobalVarDeclarationError () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleGlobalVarDeclarationError(\n");

        buffer.append(tab);
        buffer.append(") [SingleGlobalVarDeclarationError]");
        return buffer.toString();
    }
}