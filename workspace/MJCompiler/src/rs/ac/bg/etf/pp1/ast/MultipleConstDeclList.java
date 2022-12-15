// generated with ast extension for cup
// version 0.8
// 15/11/2022 16:44:41


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDeclList extends MultipleConstDecl {

    private String I1;
    private Constant Constant;
    private MultipleConstDecl MultipleConstDecl;

    public MultipleConstDeclList (String I1, Constant Constant, MultipleConstDecl MultipleConstDecl) {
        this.I1=I1;
        this.Constant=Constant;
        if(Constant!=null) Constant.setParent(this);
        this.MultipleConstDecl=MultipleConstDecl;
        if(MultipleConstDecl!=null) MultipleConstDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Constant getConstant() {
        return Constant;
    }

    public void setConstant(Constant Constant) {
        this.Constant=Constant;
    }

    public MultipleConstDecl getMultipleConstDecl() {
        return MultipleConstDecl;
    }

    public void setMultipleConstDecl(MultipleConstDecl MultipleConstDecl) {
        this.MultipleConstDecl=MultipleConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Constant!=null) Constant.accept(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Constant!=null) Constant.traverseTopDown(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Constant!=null) Constant.traverseBottomUp(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDeclList(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Constant!=null)
            buffer.append(Constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultipleConstDecl!=null)
            buffer.append(MultipleConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleConstDeclList]");
        return buffer.toString();
    }
}
