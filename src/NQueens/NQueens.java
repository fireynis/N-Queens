package NQueens;

import Board.Board;
import ChessGUI.ChessGUI;

import java.util.Random;

public class NQueens {

    Random gen;
    int seed;

    NQueens(int n) {
        doBlindSearch(n);
    }

    private void doBlindSearch(int n) {
        int[] blindBoard = new int[n];
        blindSearch(blindBoard, 0);
        doHillClimber(n);
    }

    private void doHillClimber(int n) {
        Board board = new Board(n);
        this.seed = (52);
        this.gen = new Random(seed);
        board = addQueens(board, n);
        int h = board.getHValue();
        hillClimber(board, n, h);
    }

    private void hillClimber(Board board, int n, int h) {
        if (h == 0) {
            //TODO - Add print section here to show board.
        } else {
            //TODO - The actual hill climb part. Likely create options and select best board state, then recall hillclimber with new board.
        }
    }

    private Board addQueens(Board board, int n) {
        for (int i = 0;i < n; i++) {
            int row = gen.nextInt(n);
            int col = gen.nextInt(n);
            while (board.locHasQueen(row, col)) {
                row = gen.nextInt(n);
                col = gen.nextInt(n);
            }
            board.addQueen(row, col);
        }
        return board;
    }

    private void blindSearch(int[] board, int Queen) {

        if (Queen == board.length) {
            ChessGUI display = new ChessGUI(board);
        } else {
            for (int i = 0;i < board.length; i++) {
                board[Queen] = i;
                if (canPlaceQueen(board, Queen)) {
                    blindSearch(board, Queen+1);
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

    public static void main(String[] args) {
        NQueens q = new NQueens(8);
    }

}
