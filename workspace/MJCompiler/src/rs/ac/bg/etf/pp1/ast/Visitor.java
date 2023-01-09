// generated with ast extension for cup
// version 0.8
// 9/0/2023 17:17:35


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(Constant Constant);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(OptMinusTerm OptMinusTerm);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(MethodDeclReturn MethodDeclReturn);
    public void visit(Factor Factor);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(CondTerm CondTerm);
    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(Designator Designator);
    public void visit(MethodName MethodName);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(NullableFormPars NullableFormPars);
    public void visit(OptionalDesignator OptionalDesignator);
    public void visit(MultipleVarDecl MultipleVarDecl);
    public void visit(ConstantAssignement ConstantAssignement);
    public void visit(ConstructorDeclList ConstructorDeclList);
    public void visit(ProgramName ProgramName);
    public void visit(ClassDeclName ClassDeclName);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(ActPars ActPars);
    public void visit(DesignatorList DesignatorList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MultipleConstDecl MultipleConstDecl);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(AddopTerm AddopTerm);
    public void visit(Type Type);
    public void visit(ConstDecl ConstDecl);
    public void visit(ClassDecl ClassDecl);
    public void visit(CondFact CondFact);
    public void visit(Declaration Declaration);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Program Program);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(PrintArgs PrintArgs);
    public void visit(FormPars FormPars);
    public void visit(AddopTermList AddopTermList);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(LesserEquals LesserEquals);
    public void visit(Lesser Lesser);
    public void visit(GreaterEquals GreaterEquals);
    public void visit(Greater Greater);
    public void visit(NotEquals NotEquals);
    public void visit(Equals Equals);
    public void visit(AssignopAssign AssignopAssign);
    public void visit(ArrayDesig ArrayDesig);
    public void visit(DesignatorArr DesignatorArr);
    public void visit(DesignatorDotIdent DesignatorDotIdent);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNewActParsEmpty FactorNewActParsEmpty);
    public void visit(FactorNewActPars FactorNewActPars);
    public void visit(FactorNewExpr FactorNewExpr);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignatorNoActPars FactorDesignatorNoActPars);
    public void visit(FactorDesignatorActPars FactorDesignatorActPars);
    public void visit(FactorDesignatorEmpty FactorDesignatorEmpty);
    public void visit(MultipleFactors MultipleFactors);
    public void visit(SingleFactor SingleFactor);
    public void visit(AddopTermExpr AddopTermExpr);
    public void visit(EmptyAddopTermList EmptyAddopTermList);
    public void visit(NoEmptyAddopTermList NoEmptyAddopTermList);
    public void visit(OptionalMinusTerm OptionalMinusTerm);
    public void visit(PosExpr PosExpr);
    public void visit(NoMinus NoMinus);
    public void visit(WithMinus WithMinus);
    public void visit(MultipleExpr MultipleExpr);
    public void visit(SingleExpr SingleExpr);
    public void visit(MultipleCondTerm MultipleCondTerm);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(MultipleConditions MultipleConditions);
    public void visit(SingleCondition SingleCondition);
    public void visit(ActParsList ActParsList);
    public void visit(ActPar ActPar);
    public void visit(OptionalDesignatorNotExists OptionalDesignatorNotExists);
    public void visit(OptionalDesignatorExists OptionalDesignatorExists);
    public void visit(EmptyDesignatorList EmptyDesignatorList);
    public void visit(NoEmptyDesignatorList NoEmptyDesignatorList);
    public void visit(MultipleDesignatorAssignStmt MultipleDesignatorAssignStmt);
    public void visit(DesignatorDecStmt DesignatorDecStmt);
    public void visit(DesignatorIncStmt DesignatorIncStmt);
    public void visit(DesignatorEmptyActParsStmt DesignatorEmptyActParsStmt);
    public void visit(DesignatorActParsStmt DesignatorActParsStmt);
    public void visit(DesignatorAssignStmtError DesignatorAssignStmtError);
    public void visit(DesignatorAssignStmt DesignatorAssignStmt);
    public void visit(PrintArgsEmpty PrintArgsEmpty);
    public void visit(PrintArgsNoEmpty PrintArgsNoEmpty);
    public void visit(BlockStmt BlockStmt);
    public void visit(ForeachStmt ForeachStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ReturnEmptyStmt ReturnEmptyStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(WhileStmt WhileStmt);
    public void visit(IfStmt IfStmt);
    public void visit(IfElseStmt IfElseStmt);
    public void visit(DesignatorStmt DesignatorStmt);
    public void visit(TypeIdent TypeIdent);
    public void visit(MultipleFormPars MultipleFormPars);
    public void visit(FormPar FormPar);
    public void visit(NullableFormParsEmpty NullableFormParsEmpty);
    public void visit(NullableFormParsExist NullableFormParsExist);
    public void visit(MethodNameIdent MethodNameIdent);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(MethodDeclReturnType MethodDeclReturnType);
    public void visit(MethodDeclReturnVoid MethodDeclReturnVoid);
    public void visit(EmptyStatementList EmptyStatementList);
    public void visit(NoEmptyStatementList NoEmptyStatementList);
    public void visit(ConstructorDeclFormParams ConstructorDeclFormParams);
    public void visit(ConstructorDeclNoFormParams ConstructorDeclNoFormParams);
    public void visit(SingleMethodDeclList SingleMethodDeclList);
    public void visit(MultipleMethodDeclList MultipleMethodDeclList);
    public void visit(SingleConstructorDeclList SingleConstructorDeclList);
    public void visit(MultipleConstructorDeclList MultipleConstructorDeclList);
    public void visit(ClassDeclEmpty ClassDeclEmpty);
    public void visit(ClassDeclMethod ClassDeclMethod);
    public void visit(ClassDeclCons ClassDeclCons);
    public void visit(ClassDeclMethods ClassDeclMethods);
    public void visit(ClassDeclNoMethods ClassDeclNoMethods);
    public void visit(EmptyVarDeclList EmptyVarDeclList);
    public void visit(NoEmptyVarDeclList NoEmptyVarDeclList);
    public void visit(ClassDeclNameNoExtend ClassDeclNameNoExtend);
    public void visit(ClassDeclNameExtend ClassDeclNameExtend);
    public void visit(MultipleVarDeclList MultipleVarDeclList);
    public void visit(LastMultipleVarDecl LastMultipleVarDecl);
    public void visit(SingleVarArrayDecl SingleVarArrayDecl);
    public void visit(SingleVarDeclaration SingleVarDeclaration);
    public void visit(MultipleVarDeclaration MultipleVarDeclaration);
    public void visit(SingleVarDeclarationVarDecl SingleVarDeclarationVarDecl);
    public void visit(MultipleGlobalVarDeclarationError MultipleGlobalVarDeclarationError);
    public void visit(MultipleGlobalVarDeclaration MultipleGlobalVarDeclaration);
    public void visit(SingleGlobalVarDeclarationError SingleGlobalVarDeclarationError);
    public void visit(SingleGlobalVarDeclarationVarDecl SingleGlobalVarDeclarationVarDecl);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstantAssign ConstantAssign);
    public void visit(MultipleConstDeclList MultipleConstDeclList);
    public void visit(LastMultipleConstDecl LastMultipleConstDecl);
    public void visit(MultipleConstDeclaration MultipleConstDeclaration);
    public void visit(SingleConstDecl SingleConstDecl);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(GlobalVarDeclaration GlobalVarDeclaration);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(NoDeclaration NoDeclaration);
    public void visit(DeclarationsList DeclarationsList);
    public void visit(PProgramName PProgramName);
    public void visit(ProgramNoMethods ProgramNoMethods);
    public void visit(PProgram PProgram);

}
