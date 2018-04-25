package Parser.NonTerminals;

import Parser.NonTerminals.Statement.StatementChecker;

import java.util.ArrayList;

public class MainClass extends Node{


    public MainClass() {
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< CLASS >","class"));
        classTokens.add(new TerminalNode("< ID >","id"));
        classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
        classTokens.add(new TerminalNode("< PUBLIC >","public"));
        classTokens.add(new TerminalNode("< STATIC >","static"));
        classTokens.add(new TerminalNode("< VOID >","void"));
        classTokens.add(new TerminalNode("< MAIN >","main"));
        classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
        classTokens.add(new TerminalNode("< STRING >","String"));
        classTokens.add(new TerminalNode("< LEFT_SQUARE_B >","["));
        classTokens.add(new TerminalNode("< RIGHT_SQUARE_B >","]"));
        classTokens.add(new TerminalNode("< ID >","id"));
        classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
        classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
        classTokens.add(new StatementChecker());
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
    }


    /*
    * class id{
    *       public static void main ( String[] id ){
    *
    *       }
    * }
    * */

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
        return 1;
    }
}
