package Board;

import Queen.Queen;

public class Board {

    int[][] board;
    boolean hasQueen;

    public Board(int n) {
        this.board = new int[n][n];
        this.hasQueen = false;
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

        for (int i = 0; i < this.board.length;i++) {
            if (this.board[i][col] == 1) {
                return true;
            }
        }
        return false;
    }

    public void addQueen(int x, int y) {
        this.board[x][y] = 1;
        this.hasQueen = true;
    }

    public boolean hasQueen() {
        return this.hasQueen;
    }

    public int length() {
        return this.board.length;
    }

    public boolean locHasQueen(int x, int y) {
        if (this.board[x][y] == 1) {
            return true;
        }
        return false;
    }

}
