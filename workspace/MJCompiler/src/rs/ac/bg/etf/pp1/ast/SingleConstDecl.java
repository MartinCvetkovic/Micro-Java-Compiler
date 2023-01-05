// generated with ast extension for cup
// version 0.8
// 5/0/2023 13:45:49


package rs.ac.bg.etf.pp1.ast;

public class SingleConstDecl extends ConstDecl {

    private Type Type;
    private ConstantAssignement ConstantAssignement;

    public SingleConstDecl (Type Type, ConstantAssignement ConstantAssignement) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstantAssignement=ConstantAssignement;
        if(ConstantAssignement!=null) ConstantAssignement.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstDecl(\n");

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

        buffer.append(tab);
        buffer.append(") [SingleConstDecl]");
        return buffer.toString();
    }
}
