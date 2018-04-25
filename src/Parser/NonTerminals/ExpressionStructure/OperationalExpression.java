package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.*;
import Parser.NonTerminals.Expression.Expression;

import java.util.ArrayList;

public class OperationalExpression extends Node {

    public OperationalExpression(Node node){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode(node.getType(),node.getValue()));
        classTokens.add(new Expression());
    }
}
