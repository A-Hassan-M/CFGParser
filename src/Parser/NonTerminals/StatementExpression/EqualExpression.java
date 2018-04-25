package Parser.NonTerminals.StatementExpression;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.ExpressionStructure.IndexExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class EqualExpression extends Node {

    public EqualExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< ASSIGNMENT >","="));
        classTokens.add(new Expression());
        classTokens.add(new TerminalNode("< SEMICOLON >",";"));
    }

}
