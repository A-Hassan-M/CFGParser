package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class ClassesDeclaration extends Node{
	
	public ClassesDeclaration() {
		// ClassDeclaration  ClassDeclaration`  |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new ClassDeclaration());
	}
   	@Override
	public int matches(ArrayList<Node> tokens, boolean takesLamda) {
		int matched = super.matches(tokens, takesLamda);
		if(!tokens.isEmpty()&&matched>0){
			ClassesDeclaration arguments = new ClassesDeclaration();
			if(arguments.matches(tokens, takesLamda) > 0)
				classTokens.add(arguments);
			return 1;
		}else return matched;
	}

}
