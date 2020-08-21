public class State {

    private int[][] board;

    public static final int SIZE = 9;
    public static final int EMPTY = 0;

    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int column, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int row, int column, int number) {
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

    private boolean isPossibleToPlaceNumber(int row, int column, int number) {
        return !isInRow(row, number) && !isInColumn(column, number) && !isInBox(row, column, number);
    }

    private boolean solve() {
        for (int row = 0; row < SIZE; row++){
            for (int column = 0; column < SIZE; column++) {
                if (board[row][column] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isPossibleToPlaceNumber(row, column, number)) {
                            board[row][column] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][column] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
