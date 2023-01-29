import java.util.InputMismatchException;

public class Gameplay {

    private Board board;
    private boolean playerOneTurn = true;
    private String playerOne;
    private String playerTwo;

    public Gameplay(){}
    public Gameplay(String playerOne) {
        this.playerOne = playerOne;
        this.board = new Board();
    }

    public Gameplay(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = new Board();
    }

    public void onePlayerMode(){

        System.out.println("Welcome.\n Here's your board.\nX goes first.");
        board.displayBoard();
        nextPlaySinglePlayer();

    }

    public void twoPlayerMode(){

        System.out.println("Welcome " + this.playerOne + " and " + this.playerTwo + ".\n Here's your board.\nYou go first.");
        board.displayBoard();
        nextPlayTwoPlayer();

    }

    public void start(){
        while (true) {
            System.out.println("Welcome to Tic Tac Toe! Please enter '1' for a solo game versus a computer" +
                    "\nor '2' for a two-player game.");
            try {
                int input = TicTacToe.in.nextInt();
                if (input == 1) {
                    System.out.println("Please enter your name.");
                    String playerOne = TicTacToe.in.next();
                    Gameplay gameplay = new Gameplay(playerOne);
                    gameplay.onePlayerMode();
                } else if(input == 2){
                    System.out.println("Please enter the first player's name.");
                    String playerOne = TicTacToe.in.next();
                    System.out.println("Please enter the second player's name.");
                    String playerTwo = TicTacToe.in.next();
                    Gameplay gameplay = new Gameplay(playerOne, playerTwo);
                    gameplay.twoPlayerMode();
                }
            } catch (InputMismatchException e) {
                System.out.println("Be sure to enter '1' or '2'!");
            }
        }
    }

    public void nextPlaySinglePlayer(){
        if (playerOneTurn == true){
            playerOneTurn = false;
            playerOneGo();
        }
        else {
            playerOneTurn = true;
            computerGo();
        }
    }

    public void nextPlayTwoPlayer(){
        if (playerOneTurn == true){
            playerOneTurn = false;
            playerOneGo();
        }
        else {
            playerOneTurn = true;
            playerTwoGo();
        }
    }
    public void playerOneGo(){
        board.displayBoard();
        System.out.println(playerOne + ", which space would you like to occupy?");
        int select = spaceSelect();
        board.playerOneMove(select);
        board.checkWinner();
    }

    public void playerTwoGo(){
        board.displayBoard();
        System.out.println(playerTwo + ", which space would you like to occupy?");
        int select = spaceSelect();
        board.playerTwoMove(select);
        board.checkWinner();
    }

    public void computerGo(){
        board.displayBoard();
        System.out.println("Computer is going.");
        board.computerMove();
        board.checkWinner();
    }


    public int spaceSelect(){
        while (true) {
            System.out.println("Select one of the available integer spaces.");
            try {
                int select = TicTacToe.in.nextInt();
                if(select > 9){
                    System.out.println("There's no space there!");
                    spaceSelect();
                }
                if (board.getSpaces()[select] != 'x' && board.getSpaces()[select] != 'y') {
                    return select;
                } else {
                    System.out.println("Sorry, that space is occupied.");
                    spaceSelect();
                }
            } catch (InputMismatchException e) {
                System.out.println("Be sure to enter an integer.");
            }
        }
    }


}
