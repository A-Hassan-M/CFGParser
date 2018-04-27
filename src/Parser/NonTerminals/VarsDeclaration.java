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
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        int matched = super.matches(tokens, takesLamda);
        if(!tokens.isEmpty()&&matched>0){
        	VarsDeclaration arguments = new VarsDeclaration();
            if(arguments.matches(tokens, takesLamda) > 0) // may be -1 not only 0
                classTokens.add(arguments);
            return 1;
        }else return matched;
    }
}
