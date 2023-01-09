// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public class PrintStmt extends Statement {

    private Expr Expr;
    private PrintArgs PrintArgs;

    public PrintStmt (Expr Expr, PrintArgs PrintArgs) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintArgs=PrintArgs;
        if(PrintArgs!=null) PrintArgs.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(Expr!=null) Expr.accept(visitor);
        if(PrintArgs!=null) PrintArgs.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintArgs!=null) PrintArgs.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintArgs!=null) PrintArgs.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmt(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintArgs!=null)
            buffer.append(PrintArgs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmt]");
        return buffer.toString();
    }
}
