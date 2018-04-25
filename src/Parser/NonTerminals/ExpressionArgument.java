package Parser.NonTerminals;

import Parser.NonTerminals.Expression.Expression;

import java.util.ArrayList;

public class ExpressionArgument extends Node{

    public ExpressionArgument(boolean takesLamda){
        value = "";
        this.takesLamda = takesLamda;
        classTokens = new ArrayList<>();

        classTokens.add(new Expression());
        classTokens.add(new AdditionalExpressionArguments());
    }

//    @Override
//    public int matches(ArrayList<Node> tokens) {
//        int i= 0;
//        while(!(tokens.isEmpty()) && i<classTokens.size()){
//            int matched = classTokens.get(i).matches(tokens);
//            if(matched==0){
//                return -1;
//            }
//            i++;
//        }
//        return 1;
//    }

}
