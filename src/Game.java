public class Game {
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private Player currentPlayer = player1;
    private int gameplayCounter = 0;
    private String gameplayType;
    private GameHelper gameHelper = new GameHelper();

    public void initGame() {
        UserInterface.showWelcomeMessage();
        UserInterface.showInfo();

        do {
            gameplayType = UserInterface.askForGameplayType();
        }
        while (!gameplayType.equals("C") && !gameplayType.equals("U"));

        player1.setPlayerName(UserInterface.getUserInput("Enter Player 1 name: "));
        player1.setPlayerSymbol(UserInterface.selectSymbol());

        if (gameplayType.equals("U")) {
            player2.setPlayerName(UserInterface.getUserInput("Enter Player 2 name: "));
        }
        else {
            player2.setIsComputer();
            player2.setPlayerName("Computer");
        }
        String player1Symbol = player1.getPlayerSymbol();
        if (player1Symbol.equals("X")) {
            player2.setPlayerSymbol("O");
        }
        else {
            player2.setPlayerSymbol("X");
        }

    }

    public void test() {
        System.out.println(player1.getPlayerName());
        System.out.println(player1.getPlayerSymbol());

        System.out.println(player2.getPlayerName());
        System.out.println(player2.getPlayerSymbol());

        currentPlayer = player1;
        System.out.println("Current player");
        System.out.println(currentPlayer.getPlayerName());
        System.out.println(currentPlayer.getPlayerSymbol());


        changeCurrentPlayer();

        System.out.println(player1.getPlayerName());
        System.out.println(player1.getPlayerSymbol());

        System.out.println(player2.getPlayerName());
        System.out.println(player2.getPlayerSymbol());

        System.out.println("Current player");
        System.out.println(currentPlayer.getPlayerName());
        System.out.println(currentPlayer.getPlayerSymbol());
    }
    public String gameMove() {
        String userChoice;
        String moveResult;

        UserInterface.clearScreen();
        gameHelper.showGrid();

        if (currentPlayer.getIsComputer()) {
            userChoice = gameHelper.getRandField();
            System.out.println("Computer move:");
        }
        else {
            do {
                userChoice = UserInterface.getUserInput(currentPlayer.getPlayerName() +
                        ", enter your choice (A1.." + GameHelper.LAST_FIELD + "): ");
            }
            while (!gameHelper.isEnteredFieldValid(userChoice));
        }

        moveResult = gameHelper.checkUserPlay(userChoice, currentPlayer.getPlayerSymbol());

        if (moveResult.equals("WIN")) {
            currentPlayer.incrementPlayerWinCounter();
            UserInterface.showGameplayResult("Gameplay result: " + currentPlayer.getPlayerName() + " WON" );
            gameHelper.showGrid();
            System.out.println("------------------------------");

        } else if (moveResult.equals("DRAW")) {
            UserInterface.showGameplayResult("Gameplay result: DRAW");
        }

        return moveResult;
    }

    public void gameplay() {
        String moveResult;
        String playAgain;

        do {
            gameHelper = new GameHelper();
            do {
                moveResult = gameMove();
                changeCurrentPlayer();
            }
            while (!moveResult.equals("WIN") && !moveResult.equals("DRAW"));

            gameplayCounter++;
            if (gameplayCounter % 2 == 0) {
                currentPlayer = player1;
            }
            else {
                currentPlayer = player2;
            }

            playAgain = UserInterface.getUserInput("Do you want to play again? (Y/N): ");
        }
        while (playAgain.equalsIgnoreCase("Y"));

    }

    public void gameSummary() {
        System.out.println("==============================");
        System.out.println("Games: " + gameplayCounter);
        System.out.println(player1.getPlayerName() + " won " + player1.getPlayerWinCounter() + " times");
        System.out.println(player2.getPlayerName() + " won " + player2.getPlayerWinCounter() + " times");
        System.out.println("Draws: " + (gameplayCounter - player1.getPlayerWinCounter() - player2.getPlayerWinCounter()));
    }

    private void changeCurrentPlayer() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }
}
