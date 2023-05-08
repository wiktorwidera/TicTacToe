import java.util.Scanner;

public class UserInterface {
    public static void showWelcomeMessage() {
        System.out.println("TicTacToe");
        System.out.println("==============================");
    }
    public static void showInfo() {
        System.out.println("------------------------------");
        System.out.println("Possible symbols: O/X");
        System.out.println("------------------------------");
    }

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String askForGameplayType () {
        String userInput;
        System.out.println("Please enter the game type:");
        System.out.println("Playing with (C)omputer");
        System.out.println("Playing with another (U)ser");
        userInput = getUserInput("What is your choice? ");
        return userInput;
    }

    public static String selectSymbol() {
        String enteredSymbol;
        do {
            enteredSymbol = getUserInput("Enter your symbol (O or X): ");
        }
        while(!isEnteredSymbolCorrect(enteredSymbol));
        return enteredSymbol;
    }

    private static boolean isEnteredSymbolCorrect(String symbol) {
        return symbol.equalsIgnoreCase("O") || symbol.equalsIgnoreCase("X");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showGameplayResult(String prompt) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println(prompt);
        System.out.println("------------------------------");
    }
}
