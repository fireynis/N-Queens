package Queen;

public class Queen {
    int x;
    int y;
    
    Queen() {
        x = -1;
        y = -1;
    }
    
    Queen(int row, int col) {
        this.x = row;
        this.y = col;
    }

    public int getRow() {
        return this.x;
    }

    public int getCol() {
        return this.y;
    }

    public boolean isDiagonal(Queen q, int boardSize) {

        if((this.y == q.getCol()) || (this.x == q.getRow())) {
            return false;
        }

        int rowThis = this.x;
        int colThis = this.y;

        int rowThat = q.getRow();
        int colThat = q.getCol();

        while ((colThis < boardSize) && (rowThis < boardSize)) {
            if(rowThis == rowThat && colThis == colThat) {
                return true;
            }
            rowThis++;
            colThis++;
        }

        while ((colThis >= 0) && (rowThis >= 0)) {
            if(rowThis == rowThat && colThis == colThat) {
                return true;
            }
            rowThis--;
            colThis--;
        }
        return false;
    }
    
}
