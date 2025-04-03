package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }  
    public int getCol() { return col; }  

    public Position move(Direction dir) {
        int newRow = row;
        int newCol = col;

        switch (dir) {
            case UP -> newRow = Math.max(0, row - 1);  // Prevent negative row
            case DOWN -> newRow = row + 1;  // You may need a max boundary check
            case LEFT -> newCol = Math.max(0, col - 1); // Prevent negative col
            case RIGHT -> newCol = col + 1; // You may need a max boundary check
        }

        return new Position(newRow, newCol);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public String toString() {
        return "Position(" + row + ", " + col + ")";
    }
}
