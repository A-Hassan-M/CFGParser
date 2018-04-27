package Parser.NonTerminals.HeapDeclaration;

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

}
