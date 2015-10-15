package NQueens;

import ChessGUI.ChessGUI;

public class NQueens {

    NQueens(int n) {
        doBlindSearch(n);
    }

    private void doBlindSearch(int n) {
        int[] board = new int[n];
        addQueen(board, 0);
    }

    private void addQueen(int[] board, int Queen) {

        if (Queen == board.length) {
            ChessGUI display = new ChessGUI(board);
        } else {
            for (int i = 0;i < board.length; i++) {
                board[Queen] = i;
                if (canPlaceQueen(board, Queen)) {
                    addQueen(board, Queen+1);
                }
            }
        }
    }

    private boolean canPlaceQueen(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] == board[n]){
                return false;
            }
            if ((board[i] - board[n]) == (n - i)) {
                return false;
            }
            if ((board[n] - board[i]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    int randomNum(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static void main(String[] args) {
        NQueens q = new NQueens(8);
    }

}
