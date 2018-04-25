package Parser.NonTerminals.HeapDeclaration;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.ExpressionArgument;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class ObjectHeap extends Node {


    public ObjectHeap(){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< ID >","id"));
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new ExpressionArgument());
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }else if (matched == -1){
                classTokens.remove(i);
            }else {
                i++;
            }
        }
        return 1;
    }
}
