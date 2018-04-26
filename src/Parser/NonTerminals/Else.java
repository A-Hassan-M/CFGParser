package Parser.NonTerminals;

import Parser.NonTerminals.Statement.StatementChecker;

import java.util.ArrayList;

public class Else extends Node{

    public Else(){
        value = "";
        takesLamda = true;
        classTokens = new ArrayList<>();

        classTokens.add(new TerminalNode("< ELSE >","else"));
        classTokens.add(new StatementChecker());
    }

}
