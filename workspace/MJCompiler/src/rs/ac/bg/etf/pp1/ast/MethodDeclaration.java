// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends MethodDecl {

    private MethodDeclReturn MethodDeclReturn;
    private MethodName MethodName;
    private NullableFormPars NullableFormPars;
    private VarDeclList VarDeclList;
    private StatementList StatementList;

    public MethodDeclaration (MethodDeclReturn MethodDeclReturn, MethodName MethodName, NullableFormPars NullableFormPars, VarDeclList VarDeclList, StatementList StatementList) {
        this.MethodDeclReturn=MethodDeclReturn;
        if(MethodDeclReturn!=null) MethodDeclReturn.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.NullableFormPars=NullableFormPars;
        if(NullableFormPars!=null) NullableFormPars.setParent(this);
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

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public NullableFormPars getNullableFormPars() {
        return NullableFormPars;
    }

    public void setNullableFormPars(NullableFormPars NullableFormPars) {
        this.NullableFormPars=NullableFormPars;
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
        if(MethodName!=null) MethodName.accept(visitor);
        if(NullableFormPars!=null) NullableFormPars.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclReturn!=null) MethodDeclReturn.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(NullableFormPars!=null) NullableFormPars.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclReturn!=null) MethodDeclReturn.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(NullableFormPars!=null) NullableFormPars.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodDeclReturn!=null)
            buffer.append(MethodDeclReturn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NullableFormPars!=null)
            buffer.append(NullableFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
