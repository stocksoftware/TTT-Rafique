import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Board board = new Board();

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Game game = new Game(new Player[]{player1, player2});


        while(game.getMovesMade() < 9){
            board.printBoard();
            Scanner scanner = new Scanner(System.in);
            System.out.println("It is turn of player :" + game.getMoveToMake().getIdentifier());

            boolean moveIsValid = false;
            int row = -1;
            int col = -1;
            while(!moveIsValid){
                row = getInput(game, scanner, row, "row");

                col = getInput(game, scanner, col, "col");

                moveIsValid = board.setMove(row, col, game.getMoveToMake());
                if(!moveIsValid) {
                    System.out.println("That cell is already taken!");
                    row = -1;
                    col = -1;
                }
            }
            board.printBoard();
            if(board.checkWinner(row, col, game.getMoveToMake())){
                System.out.println("The winner is: " + game.getMoveToMake().getIdentifier());
                System.out.println("Press Enter to restart the game!");
                board.resetBoard();
                game.resetGame();
                scanner.nextLine();
            }

            game.incrementMovesMade();
            game.changePlayer();
        }
    }

    private static int getInput(Game game, Scanner scanner, int place, String direction) {
        while(place == -1 || place < 0 || place > 2){
            System.out.println("Player " + game.getMoveToMake().getIdentifier() +
                    ", which " + direction +" you want to make move?");
            String input = scanner.nextLine();
            try {
                place = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Please input a number between 0 and 2");
            }
        }
        return place;
    }
}
