package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class VarsDeclaration extends Node {

	public VarsDeclaration() {
		// VarDeclaration  VarDeclaration` |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new VarDeclaration());
	}
	
    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return -1;
            }
            i++;
        }
        if(!tokens.isEmpty()){
        	VarsDeclaration arguments = new VarsDeclaration();
            if(arguments.matches(tokens) > 0) // may be -1 not only 0
                classTokens.add(arguments);
        }
        return 1;
    }
}
