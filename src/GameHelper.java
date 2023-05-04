public class GameHelper {
    Player user = new Player();
    Player computer = new Player();

    public void showWelcomeMessage() {
        System.out.println("TicTacToe");
        System.out.println("==========================");
    }

    public void showInfo() {
        System.out.println("--------------------------");
        System.out.println("O - First player sign");
        System.out.println("X - Second player sign");
        System.out.println("Other signs end the game");
        System.out.println("--------------------------");
    }

    public void gameSummary() {

    }
    private void setUserName(Player player, String name) {
        player.setPlayerName(name);
    }


}
