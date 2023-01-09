// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDeclaration extends ConstDecl {

    private Type Type;
    private ConstantAssignement ConstantAssignement;
    private MultipleConstDecl MultipleConstDecl;

    public MultipleConstDeclaration (Type Type, ConstantAssignement ConstantAssignement, MultipleConstDecl MultipleConstDecl) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstantAssignement=ConstantAssignement;
        if(ConstantAssignement!=null) ConstantAssignement.setParent(this);
        this.MultipleConstDecl=MultipleConstDecl;
        if(MultipleConstDecl!=null) MultipleConstDecl.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.accept(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseTopDown(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseBottomUp(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [MultipleConstDeclaration]");
        return buffer.toString();
    }
}
