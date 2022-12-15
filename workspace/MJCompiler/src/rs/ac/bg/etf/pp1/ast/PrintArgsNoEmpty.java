// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:16:49


package rs.ac.bg.etf.pp1.ast;

public class PrintArgsNoEmpty extends PrintArgs {

    private Integer N1;
    private PrintArgs PrintArgs;

    public PrintArgsNoEmpty (Integer N1, PrintArgs PrintArgs) {
        this.N1=N1;
        this.PrintArgs=PrintArgs;
        if(PrintArgs!=null) PrintArgs.setParent(this);
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
    }

    public PrintArgs getPrintArgs() {
        return PrintArgs;
    }

    public void setPrintArgs(PrintArgs PrintArgs) {
        this.PrintArgs=PrintArgs;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintArgs!=null) PrintArgs.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintArgs!=null) PrintArgs.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintArgs!=null) PrintArgs.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintArgsNoEmpty(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        if(PrintArgs!=null)
            buffer.append(PrintArgs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintArgsNoEmpty]");
        return buffer.toString();
    }
}
