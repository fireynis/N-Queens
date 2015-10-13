package NQueens;

import Queen.Queen;

public class NQueens {

    Queen[][] board;

    NQueens(int n) {
        board = new Queen[n][n];
        doBlindSearch();
    }

    private void doBlindSearch() {
        addQueen(board.length);
    }

    private void addQueen(int n) {

    }

}
