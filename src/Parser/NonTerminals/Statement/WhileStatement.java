package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Expression.ParenthesesExpression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.StatementExpression.StatementExpressionChecker;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class WhileStatement extends Node {

    public WhileStatement(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< WHILE >","while"));
        classTokens.add(new ParenthesesExpression());
        classTokens.add(new StatementChecker());
    }

}
