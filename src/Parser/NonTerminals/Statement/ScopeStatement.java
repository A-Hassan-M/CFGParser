package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Expression;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.TerminalNode;

import java.util.ArrayList;

public class ScopeStatement extends Node {

    ArrayList<Node> classTokens;

    public ScopeStatement(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
    }

    @Override
    public String getValue() {
        int n = tabs;
        boolean newStatement = false;
        for(Node classToken:classTokens){
            String val = classToken.getValue();
            if(val.equals("} ")){
                value += "\n";
                newStatement = true;
                n--;
            }
            if(newStatement){
                for(int i =0;i<n;i++){
                    value += "\t";
                }
                newStatement = false;
            }
            value += val;
            if(val.equals("{ ")){
                value += "\n";
                newStatement = true;
                n++;
            }else if(val.equals("; ")){
                value += "\n";
                newStatement = true;
            }

        }
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
            }
            i++;
        }
        return classTokens.size();
    }

}
