package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Else;
import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.NodeWithLamda;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class IfStatement extends NodeWithLamda {



    public IfStatement(){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< IF >","if"));
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new Expression());
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
        classTokens.add(new StatementChecker());
        classTokens.add(new Else());
    }

    public void setType(String type) {
        this.type = type;
    }
}
