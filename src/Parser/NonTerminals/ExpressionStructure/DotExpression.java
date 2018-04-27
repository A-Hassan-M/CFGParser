package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.ClassMembers.IdentifierMember;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class DotExpression extends Node {

    // TODO::Create constructor and initialize classTokens with the class tokens in the word file
    public DotExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< DOT >","."));
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        if(tokens.get(1).getType().equals("< LENGTH >")){
            classTokens.add(new TerminalNode("< LENGTH >","length"));
        }else {
            classTokens.add(new IdentifierMember());
        }
        return super.matches(tokens, takesLamda);
    }
}
