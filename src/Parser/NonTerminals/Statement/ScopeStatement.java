package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.NodeWithLamda;
import Parser.NonTerminals.Statements;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class ScopeStatement extends NodeWithLamda {


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

}
