package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class IndexExpression extends Node {

    public IndexExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< LEFT_SQUARE_B >","["));
        classTokens.add(new Expression());
        classTokens.add(new TerminalNode("< RIGHT_SQUARE_B >","]"));
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }
            i++;
        }
        return 1;
    }
}
