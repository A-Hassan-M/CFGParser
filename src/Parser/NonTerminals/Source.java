package Parser.NonTerminals;

import java.util.ArrayList;

public class Source extends Node {

    public Source(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new MainClass());
        classTokens.add(new ClassesDeclaration());
    }
}
