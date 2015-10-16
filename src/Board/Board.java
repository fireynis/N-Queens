package Board;

import ChessGUI.ChessGUI;

import java.util.Random;
import java.util.Stack;

public class Board {

    public int[] board;
    public Random gen;

    public Board(int n, int seed) {
        this.board = new int[n];
        this.gen = new Random(seed);
    }

    public Board(Board org) {
        this.board = org.board;
        this.gen = org.gen;
    }

    public void addQueen(int x, int y) {
        this.board[x] = y;
    }

    public int length() {
        return this.board.length;
    }

    public boolean locHasQueen(int x, int y) {
        return this.board[x] == y;
    }

    public int getHValue() {
        int h = 0;

        for (int i = 0; i < this.board.length; i++) {
            for (int j = i+1; j < this.board.length; j++) {
                if (this.board[i] == this.board[j]) {
                    h++;
                }
                int offset = j-1;
                if (board[i] == board[j] - offset || board[i] == board[j] + offset) {
                    h++;
                }
            }
        }
        return h;
    }

    public void print() {
        ChessGUI gui = new ChessGUI(this.board);
    }

    public Board moveQueens() {
        Board boardCopy = new Board(this);
        Board bestBoard = new Board(this);

        for (int i = 0; i < this.board.length; i++) {
            int newCol = this.gen.nextInt(this.board.length);
            while (boardCopy.getCol(i) == newCol) {
                newCol = this.gen.nextInt(this.board.length);
            }
            boardCopy.setCol(i, newCol);
            if (boardCopy.getHValue() < bestBoard.getHValue()) {
                bestBoard = boardCopy;
            }
        }
        if(this.getHValue() < bestBoard.getHValue()) {
            return this;
        } else {
            return bestBoard;
        }
    }

    public void setCol(int row, int newCol) {
        this.board[row] = newCol;
    }

    public  int getCol(int row) {
        return this.board[row];
    }
}
