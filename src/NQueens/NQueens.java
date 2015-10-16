package NQueens;

import Board.Board;
import ChessGUI.ChessGUI;

import java.util.Stack;

public class NQueens {

    int boardStates;

    NQueens(int n, int seed) {
//        doBlindSearch(n);
        doHillClimber(n, seed);
    }

    private void doBlindSearch(int n) {
        int[] blindBoard = new int[n];
        blindSearch(blindBoard, 0);
    }

    private void doHillClimber(int n, int seed) {
        Board board = new Board(n, seed);
        this.boardStates = 0;

        board = addQueens(board, n);

        hillClimber(board);
    }

    private void hillClimber(Board board) {
        while (board.getHValue() != 0) {
            board = board.moveQueens();
            System.out.println(board.getHValue());
            this.boardStates++;
        }
        System.out.println(this.boardStates);
        board.print();
    }

    private Board addQueens(Board board, int n) {
        for (int i = 0;i < n; i++) {
            int col = board.gen.nextInt(n);
            while (board.locHasQueen(i, col)) {
                col = board.gen.nextInt(n);
            }
            board.addQueen(i, col);
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
                    blindSearch(board, Queen + 1);
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
        NQueens q = new NQueens(4, 52);
    }

}
