// generated with ast extension for cup
// version 0.8
// 15/11/2022 16:44:41


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclNameNoExtend extends ClassDeclName {

    private String I1;

    public ClassDeclNameNoExtend (String I1) {
        this.I1=I1;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        buffer.append("ClassDeclNameNoExtend(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclNameNoExtend]");
        return buffer.toString();
    }
}
