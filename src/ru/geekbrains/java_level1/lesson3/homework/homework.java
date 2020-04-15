package ru.geekbrains.java_level1.lesson3.homework;

        import java.util.Random;
        import java.util.Scanner;

public class homework {

    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    // init field
    private static void initMap() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    // human turn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSizeX);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isEmptyCell(y, x) && isValidCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    // is cell empty
    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    // is cell valid
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // check player's possibility to win
    private static boolean possibilityToWin(char player){
        for(int i = 0; i < fieldSizeY; i++)
            for(int j = 0; j < fieldSizeX; j++){
                if(isEmptyCell(i,j)) {
                    field[i][j] = player;
                    if (checkWin(player)) {
                        field[i][j] = AI_DOT;
                        return true;
                    } else field[i][j] = EMPTY_DOT;
                }
            }
        return false;
    }

    // ai turn
    private static void aiTurn() {
        int x;
        int y;

        if (!(possibilityToWin(AI_DOT))) //в первую очередь проверить, может ли ИИ победить сейчас
            if (!(possibilityToWin(HUMAN_DOT))) { //и только потом -- человек
                do { //иначе ставим точку рандомно
                    x = RANDOM.nextInt(fieldSizeX);
                    y = RANDOM.nextInt(fieldSizeY);
                } while (!isEmptyCell(y, x));
                field[y][x] = AI_DOT;
            }
    }
    /*
    Переделать проверку победы, чтобы она не была реализована просто набором условий.
    Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
    */
    //check line
    private static boolean checkLine(int y, int x, int coifY, int coifX, char c){
        int victoryCriterion = 4; //сколько нужно символов подряд чтобы выиграть
        int wayX = x + (victoryCriterion - 1) * coifX;
        int wayY = y + (victoryCriterion - 1) * coifY;

        if (wayX < 0 || wayY < 0 || wayX > fieldSizeX - 1 || wayY > fieldSizeY - 1) return false;

        for (int i = 0; i < victoryCriterion; i++) {
            int checkY = y + i * coifY;
            int checkX = x + i * coifX;
            if (field[checkY][checkX] != c) return false;
        }
        return true;
    }

    // check win
    private static boolean checkWin(char c) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (checkLine(i, j, 0, 1, c)) return true; // горизонталь
                if (checkLine(i, j, 1, 1, c)) return true; // диагональ х у
                if (checkLine(i, j, 1, 0, c)) return true; // вертикаль
                if (checkLine(i, j, -1, 1, c)) return true; // диагональ х -у
            }
        }
        return false;
    }

    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        SCANNER.close();
    }

    private static boolean gameChecks(char aiDot, String s) {
        if (checkWin(aiDot)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }
}
