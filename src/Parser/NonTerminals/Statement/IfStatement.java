package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Else;
import Parser.NonTerminals.Expression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class IfStatement extends Node {

    ArrayList<Node> classTokens;


    public IfStatement(){
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< IF >","if"));
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new Expression());
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
        classTokens.add(new StatementChecker());
        classTokens.add(new Else());
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }else if (matched == -1){
                classTokens.remove(i);
            }else {
                i++;
            }
        }
        return 1;
    }

}
