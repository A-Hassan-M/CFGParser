package Parser.NonTerminals;

import Parser.NonTerminals.Expression.Expression;

import java.util.ArrayList;

public class AdditionalExpressionArguments extends Node{

    public AdditionalExpressionArguments(){
        value = "";
        takesLamda = true;
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< COMMA >",","));
        classTokens.add(new Expression());
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        int matched = super.matches(tokens, takesLamda);
        if(!tokens.isEmpty()&&matched>0){
            AdditionalExpressionArguments arguments = new AdditionalExpressionArguments();
            if(arguments.matches(tokens, takesLamda) > 0)
                classTokens.add(arguments);
            return 1;
        }else return matched;
    }

}
