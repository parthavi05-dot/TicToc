public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        int row = 1;
        int col = 1;
        char symbol = 'X';

        placeMove(board, row, col, symbol);

        printBoard(board);
    }

    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
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