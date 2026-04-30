import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        int slot = getUserInput();
        System.out.println("User selected slot: " + slot);
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int slot = scanner.nextInt();
        return slot;
    }
}