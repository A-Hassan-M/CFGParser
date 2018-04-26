package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class MethodsDelcaration extends Node{

	public MethodsDelcaration() {
		// MethodDeclaration  MethodDeclaration`  |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new MethodDelcaration());
	}
	
    @Override
    public int matches(ArrayList<Node> tokens) {
        int matched = super.matches(tokens);
        if(!tokens.isEmpty()&&matched>0){
        	MethodsDelcaration arguments = new MethodsDelcaration();
            if(arguments.matches(tokens) > 0) // may be -1 not only 0
                classTokens.add(arguments);
            return 1;
        }else return matched;
    }

}
