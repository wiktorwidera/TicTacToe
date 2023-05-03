public class Player {
    private String playerName;
    private String playerSign;
    private int playerWinCounter = 0;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerSign(String playerSign) {
        this.playerSign = playerSign;
    }

    public String getPlayerSign() {
        return playerSign;
    }

    public void setPlayerWinCounter(int playerWinCounter) {
        this.playerWinCounter = playerWinCounter;
    }

    public int getPlayerWinCounter() {
        return playerWinCounter;
    }
}
