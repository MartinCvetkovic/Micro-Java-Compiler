// generated with ast extension for cup
// version 0.8
// 5/0/2023 13:45:49


package rs.ac.bg.etf.pp1.ast;

public class MultipleVarDeclList extends MultipleVarDecl {

    private SingleVarDecl SingleVarDecl;
    private MultipleVarDecl MultipleVarDecl;

    public MultipleVarDeclList (SingleVarDecl SingleVarDecl, MultipleVarDecl MultipleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
        if(SingleVarDecl!=null) SingleVarDecl.setParent(this);
        this.MultipleVarDecl=MultipleVarDecl;
        if(MultipleVarDecl!=null) MultipleVarDecl.setParent(this);
    }

    public SingleVarDecl getSingleVarDecl() {
        return SingleVarDecl;
    }

    public void setSingleVarDecl(SingleVarDecl SingleVarDecl) {
        this.SingleVarDecl=SingleVarDecl;
    }

    public MultipleVarDecl getMultipleVarDecl() {
        return MultipleVarDecl;
    }

    public void setMultipleVarDecl(MultipleVarDecl MultipleVarDecl) {
        this.MultipleVarDecl=MultipleVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.accept(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleVarDecl!=null) SingleVarDecl.traverseTopDown(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleVarDecl!=null) SingleVarDecl.traverseBottomUp(visitor);
        if(MultipleVarDecl!=null) MultipleVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVarDeclList(\n");

        if(SingleVarDecl!=null)
            buffer.append(SingleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleVarDecl!=null)
            buffer.append(MultipleVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVarDeclList]");
        return buffer.toString();
    }
}
