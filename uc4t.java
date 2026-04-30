public class TicTacToe {

    public static void main(String[] args) {

        int slot = 5;

        int[] position = convertSlotToIndex(slot);

        System.out.println("Row: " + position[0]);
        System.out.println("Column: " + position[1]);
    }

    public static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }
}