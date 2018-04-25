package Parser.NonTerminals;

import Parser.NonTerminals.ExpressionStructure.ExpressionStructureChecker;
import Parser.NonTerminals.Statement.StatementChecker;

import java.util.ArrayList;

public class Statements extends Node{
//    StatementChecker statement;
//    Statements statements;

    public Statements(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new StatementChecker());
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return -1;
            }
            i++;
        }
        if(!tokens.isEmpty()){
            Statements statements = new Statements();
            if(statements.matches(tokens) > 0)
                classTokens.add(statements);
        }
        return 1;
    }

}
