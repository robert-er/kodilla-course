public class Displayer {

    public void display(int[][] board) {
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                System.out.print(" " + board[i][j]);
                if (j % 3 == 2 && j != Board.SIZE - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i % 3 == 2 && i != Board.SIZE - 1) {
                System.out.println("------- ------- ------");
            }
        }
        System.out.println();
    }
}

