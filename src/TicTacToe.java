import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Gameplay gameplay = new Gameplay();
        gameplay.start();
    }
}
