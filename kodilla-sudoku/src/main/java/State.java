import java.util.Random;

public class State {

    private static final int AMOUNT_OF_NUMBERS_TO_SOLVE = 78;
    private static int[][] solvedBoard = new int[Board.SIZE][Board.SIZE];
    private static int[][] boardToSolve = new int[Board.SIZE][Board.SIZE];

    public static boolean isPossibleToPlaceNumber(int[][] board, int row, int column, int number) {
        return !isInRow(board, row, number) && !isInColumn(board, column, number) && !isInBox(board, row, column, number);
    }

    public static boolean solve(int[][] board) {
        copyBoard(board, solvedBoard);
        for (int row = 0; row < Board.SIZE; row++){
            for (int column = 0; column < Board.SIZE; column++) {
                if (board[row][column] == Board.EMPTY) {
                    for (int number = 1; number <= Board.SIZE; number++) {
                        if (isPossibleToPlaceNumber(board, row, column, number)) {
                            solvedBoard[row][column] = number;

                            if (solve(solvedBoard)) {
                                return true;
                            } else {
                                solvedBoard[row][column] = Board.EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



    public static void generateBoardToSolve() {
        copyBoard(solvedBoard, boardToSolve);
        Random random = new Random();
        int row;
        int column;
        int counter = Board.SIZE * Board.SIZE - AMOUNT_OF_NUMBERS_TO_SOLVE;
        while (counter > 0) {
            row = random.nextInt(9);
            column = random.nextInt(9);
            if (boardToSolve[row][column] != Board.EMPTY) {
                boardToSolve[row][column] = Board.EMPTY;
                counter--;
            }
        }
    }

    public static int[][] getSolvedBoard() {
        return solvedBoard;
    }

    public static int[][] getBoardToSolve() {
        return boardToSolve;
    }

    public static void copyBoard(int[][] boardFrom, int[][] boardTo) {
        for (int i = 0; i < Board.SIZE; i++) {
            for ( int j = 0; j < Board.SIZE; j++) {
                boardTo[i][j] = boardFrom[i][j];
            }
        }
    }

    private static boolean isInRow(int[][] board, int row, int number) {
        for (int i = 0; i < Board.SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInColumn(int[][] board, int column, int number) {
        for (int i = 0; i < Board.SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInBox(int[][] board, int row, int column, int number) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }


}
