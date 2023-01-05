// generated with ast extension for cup
// version 0.8
// 5/0/2023 15:9:0


package rs.ac.bg.etf.pp1.ast;

public class LastMultipleConstDecl extends MultipleConstDecl {

    private ConstantAssignement ConstantAssignement;

    public LastMultipleConstDecl (ConstantAssignement ConstantAssignement) {
        this.ConstantAssignement=ConstantAssignement;
        if(ConstantAssignement!=null) ConstantAssignement.setParent(this);
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
        if(ConstantAssignement!=null) ConstantAssignement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantAssignement!=null) ConstantAssignement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantAssignement!=null) ConstantAssignement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LastMultipleConstDecl(\n");

        if(ConstantAssignement!=null)
            buffer.append(ConstantAssignement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LastMultipleConstDecl]");
        return buffer.toString();
    }
}
