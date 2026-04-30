import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char userSymbol = 'X';
        char computerSymbol = 'O';

        boolean isUserTurn = random.nextBoolean();
        boolean gameOver = false;

        printBoard(board);

        while (!gameOver) {

            if (isUserTurn) {
                int slot = scanner.nextInt();
                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (isValidMove(board, row, col)) {
                    board[row][col] = userSymbol;
                    printBoard(board);

                    if (checkWin(board, userSymbol)) {
                        System.out.println("User Wins");
                        gameOver = true;
                    } else if (isBoardFull(board)) {
                        System.out.println("Draw");
                        gameOver = true;
                    } else {
                        isUserTurn = false;
                    }
                }
            } else {
                makeComputerMove(board, computerSymbol);
                printBoard(board);

                if (checkWin(board, computerSymbol)) {
                    System.out.println("Computer Wins");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    System.out.println("Draw");
                    gameOver = true;
                } else {
                    isUserTurn = true;
                }
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    public static void makeComputerMove(char[][] board, char symbol) {
        Random random = new Random();
        while (true) {
            int slot = random.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(board, row, col)) {
                board[row][col] = symbol;
                break;
            }
        }
    }

    public static boolean checkWin(char[][] board, char symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
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