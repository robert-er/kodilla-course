import java.util.Random;

public class Board {

    public static final int SIZE = 9;
    public static final int EMPTY = 0;
    public static final int AMOUNT_OF_GENERATED_NUMBERS = 10;

    private int[][] board = new int[SIZE][SIZE];

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        State.copyBoard(board, this.board);
    }

    public void putNumber(int row, int column, int number) {
        if (State.isPossibleToPlaceNumber(board, row, column, number)) {
            board[row][column] = number;
        } else {
            System.out.println("Put new number failed.");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for ( int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void generateBoard() {
        Random random = new Random();
        int row;
        int column;
        int number;
        int counter = AMOUNT_OF_GENERATED_NUMBERS;

        for (int i = 0; i < SIZE; i++) {
            for ( int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }

       while ( counter > 0) {
           row = random.nextInt(9);
           column = random.nextInt(9);
           number = random.nextInt(9) + 1;
           if (board[row][column] == EMPTY) {
               if (State.isPossibleToPlaceNumber(board, row, column, number)) {

                   board[row][column] = number;
                   counter--;
               }
           }
       }
    }
}
