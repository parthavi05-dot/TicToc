import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {
                {'X', '-', 'O'},
                {'-', '-', '-'},
                {'O', '-', 'X'}
        };

        char computerSymbol = 'O';

        makeComputerMove(board, computerSymbol);

        printBoard(board);
    }

    public static void makeComputerMove(char[][] board, char symbol) {

        Random random = new Random();
        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (isValidMove(board, row, col)) {
                board[row][col] = symbol;
                break;
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}