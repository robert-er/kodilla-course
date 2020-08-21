public class Displayer {

    private int[][] board = new int[State.SIZE][State.SIZE];

    public void display() {
        for (int i = 0; i < State.SIZE; i++) {
            for (int j = 0; j < State.SIZE; j++) {
                System.out.print(" " + board[i][j]);
                if (j % 3 == 2 && j != State.SIZE - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i % 3 == 2 && i != State.SIZE - 1) {
                System.out.println("------- ------- ------");
            }
        }
    }
}
