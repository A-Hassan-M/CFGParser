package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class ClassDeclaration extends NodeWithLamda{
    
	public ClassDeclaration() {
		//“class”  Identifier  Extends`  “{“  VarDeclaration`   ConstructorDeclaration`  MethodDeclaration` “}”
		classTokens = new ArrayList<>();
		classTokens.add(new TerminalNode("< CLASS >", "class") );
		classTokens.add(new TerminalNode("< ID >", "x"));
		classTokens.add(new Extention());
        classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
        classTokens.add(new VarsDeclaration());
        classTokens.add(new ConstructorsDeclaration());
        classTokens.add(new MethodsDelcaration());
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
        
	}
}
