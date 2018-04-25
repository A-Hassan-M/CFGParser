package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.StatementExpression.StatementExpressionChecker;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class IdentifierStatement extends Node {

    public IdentifierStatement(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< ID >","id"));
        classTokens.add(new StatementExpressionChecker());

    }

}
