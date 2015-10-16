package Board;

public class Board {

    int[][] board;
    boolean hasQueen;
    public int numQueens;

    public Board(int n) {
        this.board = new int[n][n];
        this.hasQueen = false;
        numQueens = 0;
    }

    public boolean rowHasQueen(int row) {

        for (int i = 0; i < this.board.length;i++) {
            if (this.board[row][i] == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean colHasQueen(int col) {

        for (int[] aBoard : this.board) {
            if (aBoard[col] == 1) {
                return true;
            }
        }
        return false;
    }

    public void addQueen(int x, int y) {
        this.board[x][y] = 1;
        this.hasQueen = true;
        this.numQueens++;
    }

    public boolean hasQueen() {
        return this.hasQueen;
    }

    public int length() {
        return this.board.length;
    }

    public boolean locHasQueen(int x, int y) {
        return this.board[x][y] == 1;
    }

    public int getHValue() {
        //TODO - Implement hValue determination
        return 0;
    }
}
