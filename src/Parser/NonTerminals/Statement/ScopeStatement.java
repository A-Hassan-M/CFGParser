package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Statements;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class ScopeStatement extends Node {


    public ScopeStatement(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
        classTokens.add(new Statements());
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
    }

    @Override
    public String getValue() {
        value+= super.getValue();
        return value;
    }

    public void setTabs(int tabs){
        this.tabs = tabs;
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
