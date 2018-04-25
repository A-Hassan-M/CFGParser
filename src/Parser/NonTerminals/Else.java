package Parser.NonTerminals;

import Parser.NonTerminals.Statement.StatementChecker;

import java.util.ArrayList;

public class Else extends Node{

    public Else(){
        value = "";
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< ELSE >","else"));
        classTokens.add(new StatementChecker());
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
//            System.out.println("expression "+matched);
            if(matched==0){
                return -1;
            }
            i++;
        }
        return 1;
    }

}
