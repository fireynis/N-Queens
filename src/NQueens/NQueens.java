package NQueens;

import Board.Board;
import ChessGUI.ChessGUI;

public class NQueens {

    NQueens(int n) {
        doBlindSearch(n);
    }

    private void doBlindSearch(int n) {
        Board board = new Board(n);
        board = addQueens(board, n);
        ChessGUI gui = new ChessGUI(board);
    }

    private Board addQueens(Board board, int n) {
        int x = randomNum(0, n - 1);
        int y = randomNum(0, n - 1);

        for(int i = 0; i < n; i++) {
            while (board.locHasQueen(x ,y) || board.rowHasQueen(x) || board.colHasQueen(y)) {
                x = randomNum(0, n - 1);
                y = randomNum(0, n-1);
            }
            board.addQueen(x, y);
        }
        return board;
    }

    int randomNum(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static void main(String[] args) {
        NQueens q = new NQueens(4);
    }

}
