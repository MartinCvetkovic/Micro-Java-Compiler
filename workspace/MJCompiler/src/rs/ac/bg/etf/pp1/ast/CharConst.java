// generated with ast extension for cup
// version 0.8
// 4/0/2023 14:1:52


package rs.ac.bg.etf.pp1.ast;

public class CharConst extends Constant {

    private Character charVal;

    public CharConst (Character charVal) {
        this.charVal=charVal;
    }

    public Character getCharVal() {
        return charVal;
    }

    public void setCharVal(Character charVal) {
        this.charVal=charVal;
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
        buffer.append("CharConst(\n");

        buffer.append(" "+tab+charVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConst]");
        return buffer.toString();
    }
}
