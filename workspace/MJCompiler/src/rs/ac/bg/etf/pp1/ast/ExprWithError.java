// generated with ast extension for cup
// version 0.8
// 4/0/2023 14:58:15


package rs.ac.bg.etf.pp1.ast;

public class ExprWithError extends ExprError {

    public ExprWithError () {
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
        buffer.append("ExprWithError(\n");

        buffer.append(tab);
        buffer.append(") [ExprWithError]");
        return buffer.toString();
    }
}
