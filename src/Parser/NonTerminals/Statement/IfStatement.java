package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Else;
import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Expression.ParenthesesExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class IfStatement extends Node {



    public IfStatement(){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< IF >","if"));
        classTokens.add(new ParenthesesExpression());
        classTokens.add(new StatementChecker());
        classTokens.add(new Else(true));
    }

    public void setType(String type) {
        this.type = type;
    }
}
