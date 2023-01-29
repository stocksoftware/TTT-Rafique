public class Board {

    private char[] spaces = {'1', '2' ,'3' ,'4' ,'5' ,'6' ,'7' ,'8' ,'9'};


    public Board(){
        this.spaces = spaces;
    }

    public void playerOneMove(int space){
        spaces[space - 1] = 'x';
    }

    public void playerTwoMove(int space){
        spaces[space - 1] = 'o';
    }

    public void computerMove(){
        for(int i = 0; i < spaces.length; i++){
            if(i != 'x' && i != 'o'){
                spaces[i] = 'o';
            }
        }
    }

    // This is so messy and gross but I can't think of a better way at the moment.
    public void checkWinner(){
        if(spaces[0] == 'x' && spaces[1] == 'x' && spaces[2] == 'x'
        || spaces[3] == 'x' && spaces[4] == 'x' && spaces[5] == 'x'
        || spaces[6] == 'x' && spaces[7] == 'x' && spaces[8] == 'x'
                || spaces[0] == 'x' && spaces[3] == 'x' && spaces[6] == 'x'
                || spaces[1] == 'x' && spaces[4] == 'x' && spaces[7] == 'x'
                || spaces[2] == 'x' && spaces[5] == 'x' && spaces[8] == 'x'
                || spaces[0] == 'x' && spaces[4] == 'x' && spaces[8] == 'x'
                || spaces[2] == 'x' && spaces[4] == 'x' && spaces[6] == 'x'
                ){
            System.out.println("Xs wins!\n\n");
            Gameplay newGameplay = new Gameplay();
            newGameplay.start();
        }
        else if(spaces[0] == 'o' && spaces[1] == 'o' && spaces[2] == 'o'
                || spaces[3] == 'o' && spaces[4] == 'o' && spaces[5] == 'o'
                || spaces[6] == 'o' && spaces[7] == 'o' && spaces[8] == 'o'
                || spaces[0] == 'o' && spaces[3] == 'o' && spaces[6] == 'o'
                || spaces[1] == 'o' && spaces[4] == 'o' && spaces[7] == 'o'
                || spaces[2] == 'o' && spaces[5] == 'o' && spaces[8] == 'o'
                || spaces[0] == 'o' && spaces[4] == 'o' && spaces[8] == 'o'
                || spaces[2] == 'o' && spaces[4] == 'o' && spaces[6] == 'o'
        ){
            System.out.println("Os wins!\n\n");
            Gameplay newGameplay = new Gameplay();
            newGameplay.start();
        }
    }

    public char[] getSpaces() {
        return spaces;
    }

    public void displayBoard(){
        System.out.println(spaces[0]+spaces[1]+spaces[2]+"\n"
                +spaces[3]+spaces[4]+spaces[5]+"\n"
                +spaces[6]+spaces[7]+spaces[8]+"\n");
    }
}
