package Parser.NonTerminals.Expression;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class ParenthesesExpression extends Node {

    public ParenthesesExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new Expression());
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
    }
}
