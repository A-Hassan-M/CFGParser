package Parser.NonTerminals;

import java.util.ArrayList;

public class Source extends Node {

    public Source(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new MainClass());
        classTokens.add(new ClassesDeclaration());
        classTokens.add(new TerminalNode("< EOF >","end of file"));
    }

//    @Override
//    public int matches(ArrayList<Node> tokens) {
//        int matched = super.matches(tokens);
//        if(tokens.isEmpty()&&i<classTokens.size()){
//            while(i < classTokens.size()){
//                if(classTokens.get(i).takesLamda){
//                    classTokens.remove(i);
//                }else{
//                    return 0;
//                }
//            }
//        }
//        return matched > 0 && tokens.isEmpty()?1:0;
//    }
}
