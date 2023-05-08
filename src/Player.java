public class Player {
    private String playerName;
    private String playerSymbol;
    private int playerWinCounter = 0;
    private boolean isComputer = false;

    public void setIsComputer() {
        this.isComputer = true;
    }

    public boolean getIsComputer() {
        return isComputer;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public void incrementPlayerWinCounter() {
        this.playerWinCounter++;
    }

    public int getPlayerWinCounter() {
        return playerWinCounter;
    }
}
