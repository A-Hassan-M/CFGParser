package Parser.NonTerminals;

public class TerminalToken extends Token {
    @Override
    public boolean equals(Token token) {
        return this.type.equals(token.type);
    }
}
