// generated with ast extension for cup
// version 0.8
// 15/11/2022 15:3:31


package rs.ac.bg.etf.pp1.ast;

public class AssignopAssign extends Assignop {

    public AssignopAssign () {
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
        buffer.append("AssignopAssign(\n");

        buffer.append(tab);
        buffer.append(") [AssignopAssign]");
        return buffer.toString();
    }
}