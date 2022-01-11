public class Game {

    private int movesMade;
    private Player[] players;
    private Player moveToMake;

    public Game(Player[] players){
        this.movesMade = 0;
        this.players = players;
        this.moveToMake = players[0];
    }

    public int getMovesMade() {
        return movesMade;
    }

    public void incrementMovesMade() {
        this.movesMade++;
    }

    public Player changePlayer(){
        if(moveToMake.equals(players[0])) moveToMake = players[1];
        else moveToMake = players[0];
        return moveToMake;
    }

    public Player getMoveToMake() {
        return moveToMake;
    }

    public void resetGame() {
        moveToMake = players[1];
        movesMade = -1;
    }
}
