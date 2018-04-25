package Parser.NonTerminals.StatementExpression;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.ExpressionStructure.IndexExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class BracketExpression extends Node {

    public BracketExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new IndexExpression());
        classTokens.add(new EqualExpression());
    }
}
