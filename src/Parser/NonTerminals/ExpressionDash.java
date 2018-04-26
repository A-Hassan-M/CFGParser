package Parser.NonTerminals;

import Parser.NonTerminals.ExpressionStructure.ExpressionStructureChecker;

import java.util.ArrayList;

public class ExpressionDash extends Node{

    public ExpressionDash(boolean takesLamda){
        value = "";
        this.takesLamda = takesLamda;
        classTokens = new ArrayList<>();
        classTokens.add(new ExpressionStructureChecker());
    }


    @Override
    public int matches(ArrayList<Node> tokens) {
        int matched = super.matches(tokens);
        if(!tokens.isEmpty()&&matched>0){
            ExpressionDash expressionDash = new ExpressionDash(true);
            if(expressionDash.matches(tokens) > 0)
                classTokens.add(expressionDash);
            return 1;
        }else return matched;
    }
}
