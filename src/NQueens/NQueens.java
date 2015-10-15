package NQueens;

import Board.Board;
import ChessGUI.ChessGUI;

import java.util.Stack;

public class NQueens {

    NQueens(int n) {
        doBlindSearch(n);
    }

    private void doBlindSearch(int n) {
        int[] board = new int[n];
        addQueen(board, 0);
    }

    private void addQueen(int[] board, int Queens) {

        if (Queens == board.length) {
            ChessGUI display = new ChessGUI(board);
        } else {
            for (int i = 0;i < board.length; i++) {

            }
        }
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
