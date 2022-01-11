public class Board {

    private int[][] board;

    public Board(){
        board = new int[3][3];
    }

    public int[][] getBoard(){
        return board;
    }

    public boolean setMove(int i, int j, Player player){
        if(board[i][j] != 0) return false;
        board[i][j] = player.getIdentifier();
        return true;
    }

    public boolean checkWinner(int row, int col, Player player) {
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(board[row][i] == player.getIdentifier()) count++;
        }
        if(count == 3) return true;

        count = 0;
        for(int i = 0; i < 3; i++){
            if(board[i][col] == player.getIdentifier()) count++;
        }
        if(count == 3) return true;

        count = 0;
        int i = 0;
        int j = 0;
        while(i < 3){
            if(board[i][j] == player.getIdentifier()) count++;
            i++;
            j++;
        }
        if(count == 3) return true;

        count = 0;
        i = 2;
        j = 0;
        while(i >= 0){
            if(board[i][j] == player.getIdentifier()) count++;
            i--;
            j++;
        }
        if(count == 3) return true;

        return false;
    }

    public void printBoard() {
        System.out.println("==========================");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void resetBoard() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
    }
}
