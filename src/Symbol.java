import java.util.Random;
public enum Symbol {
    O, X;

    public static Symbol getAnotherSymbol(Symbol symbol) {
        if (symbol.equals(Symbol.O)) {
            return Symbol.X;
        }
        return Symbol.O;
    }
}
