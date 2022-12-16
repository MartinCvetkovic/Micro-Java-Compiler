// generated with ast extension for cup
// version 0.8
// 16/11/2022 17:58:38


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclNoFormPars extends MethodDecl {

    private MethodDeclReturn MethodDeclReturn;
    private String I2;
    private VarDeclList VarDeclList;
    private StatementList StatementList;

    public MethodDeclNoFormPars (MethodDeclReturn MethodDeclReturn, String I2, VarDeclList VarDeclList, StatementList StatementList) {
        this.MethodDeclReturn=MethodDeclReturn;
        if(MethodDeclReturn!=null) MethodDeclReturn.setParent(this);
        this.I2=I2;
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodDeclReturn getMethodDeclReturn() {
        return MethodDeclReturn;
    }

    public void setMethodDeclReturn(MethodDeclReturn MethodDeclReturn) {
        this.MethodDeclReturn=MethodDeclReturn;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclReturn!=null) MethodDeclReturn.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclReturn!=null) MethodDeclReturn.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclReturn!=null) MethodDeclReturn.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclNoFormPars(\n");

        if(MethodDeclReturn!=null)
            buffer.append(MethodDeclReturn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclNoFormPars]");
        return buffer.toString();
    }
}
