import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameHelper {
    private static final int GRID_LENGTH = 3; // Max 26
    private static final int GRID_SIZE = GRID_LENGTH * GRID_LENGTH;
    private static final String FREE_FIELD_CHARACTER = ".";
    private static final String[] ALPHABET_FIELDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final int[] NUMBER_FIELDS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    public static String LAST_FIELD = ALPHABET_FIELDS[GRID_LENGTH - 1] + NUMBER_FIELDS[GRID_LENGTH - 1];
    private static final ArrayList<String> gridTemplateArrayList = new ArrayList<>();
    private ArrayList<String> freeFieldsArrayList = new ArrayList<>();

    static ArrayList<String> gameplayArrayList = new ArrayList<>();
    private static final Random random = new Random();

    GameHelper() {
        createGridArrays();
        createGameplayArrayList();
    }

    void createGridArrays() {
        gridTemplateArrayList.clear();
        for (int i = 0; i < GRID_LENGTH; i++) {
            for (int j = 0; j < GRID_LENGTH; j++) {
                gridTemplateArrayList.add(ALPHABET_FIELDS[j] + NUMBER_FIELDS[i]);
            }
        }
        freeFieldsArrayList =  new ArrayList<>(gridTemplateArrayList);
    }

    static void createGameplayArrayList() {
        gameplayArrayList.clear();
        for (int i = 0; i < GRID_SIZE; i++) {
            gameplayArrayList.add(FREE_FIELD_CHARACTER);
        }
    }

    public void showGrid() {
        showMatrix(gameplayArrayList);
    }
    private void showMatrix(ArrayList<String> arrayList) {
        System.out.print("  ");
        for (int i = 0; i < GRID_LENGTH; i++) {
            System.out.print(ALPHABET_FIELDS[i] + " ");
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % GRID_LENGTH == 0) {
                System.out.println();
                System.out.print(i / GRID_LENGTH + 1 + " ");
            }
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }

    private void setGridField(String field, String symbol) {
        int index = gridTemplateArrayList.indexOf(field.toUpperCase());
        gameplayArrayList.set(index, symbol);
        removeFieldFromFreeFieldsArrayList(field.toUpperCase());
    }

    private void removeFieldFromFreeFieldsArrayList(String field) {
        freeFieldsArrayList.remove(field);
    }

    public String checkUserPlay(String field, String symbol) {
        String result = "CONTINUE";
        ArrayList<String> testArrayList = new ArrayList<>();

        setGridField(field, symbol);

        // sprawdzenie czy w kolumnie sa te same, oczekiwane symbole
        for (int i = 0; i < GRID_LENGTH; i++) {
            testArrayList.clear();
            for (int j = 0; j < GRID_SIZE; j += GRID_LENGTH) {
                if (gameplayArrayList.get(i + j).equals(symbol)) {
                    testArrayList.add(gameplayArrayList.get(i + j));
                }
            }
            if (testArrayList.size() == GRID_LENGTH) {
                result = "WIN";
                break;
            }
        }

        // sprawdzenie czy w wierszu sa te same, oczekiwane symbole
        for (int i = 0; i < GRID_SIZE; i += GRID_LENGTH) {
            testArrayList.clear();
            for (int j = 0; j < GRID_LENGTH; j++) {
                if (gameplayArrayList.get(i + j).equals(symbol)) {
                    testArrayList.add(gameplayArrayList.get(i + j));
                }
            }
            if (testArrayList.size() == GRID_LENGTH) {
                result = "WIN";
                break;
            }
        }

        // sprawdzenie przekatnych
        // pierwsza przekatna (od lewej do prawej)
        testArrayList.clear();
        for (int i = 0; i < GRID_LENGTH; i++) {
            if (gameplayArrayList.get(i * (GRID_LENGTH + 1)).equals(symbol)) {
                testArrayList.add(gameplayArrayList.get(i * (GRID_LENGTH + 1)));
            }
        }
        if (testArrayList.size() == GRID_LENGTH) {
            result = "WIN";
        }

        // druga przekatna (od prawej do lewej)
        testArrayList.clear();
        for (int i = 0; i < GRID_LENGTH; i++) {
            if (gameplayArrayList.get((i + 1) * (GRID_LENGTH - 1)).equals(symbol)) {
                testArrayList.add(gameplayArrayList.get((i + 1) * (GRID_LENGTH - 1)));
            }
        }
        if (testArrayList.size() == GRID_LENGTH) {
            result = "WIN";
        }

        if (Collections.frequency(gameplayArrayList, FREE_FIELD_CHARACTER) == 0 && !result.equals("WIN")) {
            result = "DRAW";
        }

        return result;
    }

    public String getRandField() {
        int index = random.nextInt(freeFieldsArrayList.size()); // get random free location index
        return freeFieldsArrayList.get(index);
    }

    public boolean isEnteredFieldValid(String field) {
        return freeFieldsArrayList.contains(field.toUpperCase());
    }
}
