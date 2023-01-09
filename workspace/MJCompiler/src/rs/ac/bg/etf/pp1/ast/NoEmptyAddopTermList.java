// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public class NoEmptyAddopTermList extends AddopTermList {

    private AddopTerm AddopTerm;
    private AddopTermList AddopTermList;

    public NoEmptyAddopTermList (AddopTerm AddopTerm, AddopTermList AddopTermList) {
        this.AddopTerm=AddopTerm;
        if(AddopTerm!=null) AddopTerm.setParent(this);
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
    }

    public AddopTerm getAddopTerm() {
        return AddopTerm;
    }

    public void setAddopTerm(AddopTerm AddopTerm) {
        this.AddopTerm=AddopTerm;
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
        if(AddopTerm!=null) AddopTerm.accept(visitor);
        if(AddopTermList!=null) AddopTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTerm!=null) AddopTerm.traverseTopDown(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTerm!=null) AddopTerm.traverseBottomUp(visitor);
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoEmptyAddopTermList(\n");

        if(AddopTerm!=null)
            buffer.append(AddopTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoEmptyAddopTermList]");
        return buffer.toString();
    }
}
