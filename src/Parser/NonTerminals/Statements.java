package Parser.NonTerminals;

import Parser.NonTerminals.Statement.StatementChecker;

import java.util.ArrayList;

public class Statements extends Node{

    public Statements(){
        value = "";
        takesLamda = true;
        classTokens = new ArrayList<>();
        classTokens.add(new StatementChecker());
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        int matched = super.matches(tokens, takesLamda);
        if(!tokens.isEmpty()&&matched>0){
            Statements statements = new Statements();
            if(statements.matches(tokens, takesLamda) > 0)
                classTokens.add(statements);
            return 1;
        }else return matched;
    }

}
