package Parser.NonTerminals;

import java.util.ArrayList;

public class Source extends Node {
    MainClass mainClass;
    ArrayList<ClassDeclaration> classesDeclaration;

    public Source(){
        value = "";
        mainClass = new MainClass();
        classesDeclaration = new ArrayList<>();
    }
    @Override
    public String getValue() {
        String value = mainClass.getValue();
//        for(ClassDeclaration classDeclaration:classesDeclaration){
//            value += classDeclaration.getValue();
//        }
        return value;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        ArrayList<Node> tempTokens = new ArrayList<>(tokens);
        int cond1 = mainClass.matches(tempTokens);
        if(cond1 == 0) return 0;
//        while(!(tempTokens.isEmpty())){
//            ClassDeclaration tempClassDeclaration = new ClassDeclaration();
//            if(tempClassDeclaration.matches(tempTokens) > 0)
//                classesDeclaration.add(tempClassDeclaration);
//            else return 0;
//        }
        return 1;
    }
}
