package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Expression.ParenthesesExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class PrintStatement extends Node {

    public PrintStatement(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< SYSTEM.OUT.PRINTLN >","system.out.println"));
        classTokens.add(new ParenthesesExpression());
        classTokens.add(new TerminalNode("< SEMICOLON >",";"));
    }

    @Override
    public String getValue() {
        value = super.getValue();
        return value;
    }

}
