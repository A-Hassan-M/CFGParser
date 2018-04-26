package Parser.NonTerminals;

import Parser.NonTerminals.Expression.Expression;

import java.util.ArrayList;

public class AdditionalExpressionArguments extends Node{

    public AdditionalExpressionArguments(){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< COMMA >",","));
        classTokens.add(new Expression());
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        super.matches(tokens);
        if(!tokens.isEmpty()){
            AdditionalExpressionArguments arguments = new AdditionalExpressionArguments();
            if(arguments.matches(tokens) > 0)
                classTokens.add(arguments);
        }
        return 1;
    }

}
