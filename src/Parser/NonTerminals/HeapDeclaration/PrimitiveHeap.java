package Parser.NonTerminals.HeapDeclaration;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.ExpressionStructure.IndexExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class PrimitiveHeap extends Node {


    public PrimitiveHeap(Node dataType){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode(dataType.getType(),dataType.getValue()));
        classTokens.add(new IndexExpression());
    }

}
