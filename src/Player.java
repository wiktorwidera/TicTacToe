public class Player {
    private String playerName;
    private Symbol playerSymbol;
    private int playerWinCounter = 0;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerSymbol(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public void incrementPlayerWinCounter() {
        this.playerWinCounter++;
    }

    public int getPlayerWinCounter() {
        return playerWinCounter;
    }
}
