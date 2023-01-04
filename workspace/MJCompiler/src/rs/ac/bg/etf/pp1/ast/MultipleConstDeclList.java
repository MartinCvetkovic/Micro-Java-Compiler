// generated with ast extension for cup
// version 0.8
// 4/0/2023 14:1:52


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDeclList extends MultipleConstDecl {

    private ConstantAssignement ConstantAssignement;
    private MultipleConstDecl MultipleConstDecl;

    public MultipleConstDeclList (ConstantAssignement ConstantAssignement, MultipleConstDecl MultipleConstDecl) {
        this.ConstantAssignement=ConstantAssignement;
        if(ConstantAssignement!=null) ConstantAssignement.setParent(this);
        this.MultipleConstDecl=MultipleConstDecl;
        if(MultipleConstDecl!=null) MultipleConstDecl.setParent(this);
    }

    public ConstantAssignement getConstantAssignement() {
        return ConstantAssignement;
    }

    public void setConstantAssignement(ConstantAssignement ConstantAssignement) {
        this.ConstantAssignement=ConstantAssignement;
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
        if(ConstantAssignement!=null) ConstantAssignement.accept(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseTopDown(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantAssignement!=null) ConstantAssignement.traverseBottomUp(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDeclList(\n");

        if(ConstantAssignement!=null)
            buffer.append(ConstantAssignement.toString("  "+tab));
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
