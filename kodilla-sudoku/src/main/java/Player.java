import java.util.Scanner;

public class Player {

    private Displayer displayer = new Displayer();
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
    private String scannerInput;

    public void startMenu() {
        boolean end = false;
        String menu = "";
        boolean dataOK = false;

        board.generateBoard();
        State.solve(board.getBoard());
        State.generateBoardToSolve();

        System.out.println("welcome in SUDOKU");

        while (!end) {
            while (!dataOK) {
                System.out.println(" n - new game, x - quit");
                scannerInput = scanner.nextLine();
                if (scannerInput.equals("n") || scannerInput.equals("x")) {
                    menu = scannerInput;
                    dataOK = true;
                }
            }
            dataOK = false;
            switch (menu) {
                case "n":
                    playGame();
                    break;
                case "x":
                    end = true;
                    break;
            }
        }
    }

    private void playGame() {
        boolean solved = false;
        System.out.println("board to solve");
        displayer.display(State.getBoardToSolve());
        board.setBoard(State.getBoardToSolve());

        while (!solved) {
            System.out.println("Type row,column,number to put number or SUDOKU to see solved board");
            scannerInput = scanner.nextLine();
            if (scannerInput.equals("SUDOKU")) {
                solveSudoku();
            } else {
                solved = isSolved();
                verifyIfSolved(solved);
            }

        }
    }

    private void solveSudoku() {
        if (State.solve(board.getBoard())) {
            System.out.println("solved board");
            displayer.display(State.getSolvedBoard());
        } else {
            System.out.println("State.solve failed");
        }
    }

    private boolean isSolved() {
        String[] numbers;
        boolean solved;
        numbers = scannerInput.split(",", 3);
        System.out.println("your choice: row " + numbers[0] + " ,column " + numbers[1] + " ,number " + numbers[2]);
        board.putNumber(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));
        displayer.display(board.getBoard());
        solved = board.isFull();
        return solved;
    }

    private void verifyIfSolved(boolean solved) {
        if (solved) {
            System.out.println("SUDOKU IS SOLVED!");
        }
    }
}
