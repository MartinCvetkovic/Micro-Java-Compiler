// generated with ast extension for cup
// version 0.8
// 15/11/2022 11:19:10


package rs.ac.bg.etf.pp1.ast;

public class ReturnEmptyStmt extends Statement {

    public ReturnEmptyStmt () {
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
        buffer.append("ReturnEmptyStmt(\n");

        buffer.append(tab);
        buffer.append(") [ReturnEmptyStmt]");
        return buffer.toString();
    }
}
