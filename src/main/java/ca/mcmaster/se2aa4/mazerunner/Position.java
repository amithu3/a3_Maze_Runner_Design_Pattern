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
        return switch (dir) {
            case UP -> new Position(row - 1, col);
            case DOWN -> new Position(row + 1, col);
            case LEFT -> new Position(row, col - 1);
            case RIGHT -> new Position(row, col + 1);
        };
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
