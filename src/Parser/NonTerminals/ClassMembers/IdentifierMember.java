package Parser.NonTerminals.ClassMembers;

import Parser.NonTerminals.ExpressionArgument;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

// Hassan will implement this class
public class IdentifierMember extends Node {

    public IdentifierMember(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< ID >","id"));
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new ExpressionArgument(true));
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
    }
}
