// generated with ast extension for cup
// version 0.8
// 5/0/2023 13:45:49


package rs.ac.bg.etf.pp1.ast;

public class PProgramName extends ProgramName {

    private String progName;

    public PProgramName (String progName) {
        this.progName=progName;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName=progName;
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
        buffer.append("PProgramName(\n");

        buffer.append(" "+tab+progName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PProgramName]");
        return buffer.toString();
    }
}
