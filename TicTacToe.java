
import java.util.Scanner;

public class TicTacToe {

    private LinkedList board;  // The board represented by a linked list
    private String currentPlayer;  // Keeps track of current player ('X' or 'O')

    // Constructor to initialize the game
    public TicTacToe() {
        this.board = new LinkedList();
        for (int i = 1; i <= 9; i++) {
            this.board.insertAtEnd("");
        }
        this.currentPlayer = "X";  // 'X' starts the game
    }

    // Method to switch players
    public void switchPlayer() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    // Method to play the game
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!board.isBoardFull() && !gameWon) {
            board.displayBoard();
            System.out.println("Player " + this.currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            // Validate move and update board
            if (move >= 1 && move <= 9 && board.getPositionValue(move).equals("")) {
                board.updatePosition(move, this.currentPlayer);
                gameWon = board.checkWinCondition();

                if (!gameWon) {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        board.displayBoard();

        if (gameWon) {
            System.out.println("Player " + this.currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
