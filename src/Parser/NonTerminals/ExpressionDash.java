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
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
//            System.out.println("expression dash "+matched);
            if(matched==0){
                return -1;
            }
            i++;
        }
        if(!tokens.isEmpty()){
            ExpressionDash expressionDash = new ExpressionDash(true);
            if(expressionDash.matches(tokens) > 0)
                classTokens.add(expressionDash);
        }
        return 1;
    }
}
