// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public class PosExpr extends Expr {

    private OptMinusTerm OptMinusTerm;
    private AddopTermList AddopTermList;

    public PosExpr (OptMinusTerm OptMinusTerm, AddopTermList AddopTermList) {
        this.OptMinusTerm=OptMinusTerm;
        if(OptMinusTerm!=null) OptMinusTerm.setParent(this);
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
    }

    public OptMinusTerm getOptMinusTerm() {
        return OptMinusTerm;
    }

    public void setOptMinusTerm(OptMinusTerm OptMinusTerm) {
        this.OptMinusTerm=OptMinusTerm;
    }

    public AddopTermList getAddopTermList() {
        return AddopTermList;
    }

    public void setAddopTermList(AddopTermList AddopTermList) {
        this.AddopTermList=AddopTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptMinusTerm!=null) OptMinusTerm.accept(visitor);
        if(AddopTermList!=null) AddopTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptMinusTerm!=null) OptMinusTerm.traverseTopDown(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptMinusTerm!=null) OptMinusTerm.traverseBottomUp(visitor);
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PosExpr(\n");

        if(OptMinusTerm!=null)
            buffer.append(OptMinusTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PosExpr]");
        return buffer.toString();
    }
}
