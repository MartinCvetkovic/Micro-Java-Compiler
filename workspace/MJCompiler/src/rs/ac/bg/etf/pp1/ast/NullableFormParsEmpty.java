// generated with ast extension for cup
// version 0.8
// 6/0/2023 17:3:24


package rs.ac.bg.etf.pp1.ast;

public class NullableFormParsEmpty extends NullableFormPars {

    public NullableFormParsEmpty () {
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
        buffer.append("NullableFormParsEmpty(\n");

        buffer.append(tab);
        buffer.append(") [NullableFormParsEmpty]");
        return buffer.toString();
    }
}
