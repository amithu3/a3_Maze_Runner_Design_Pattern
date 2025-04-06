package ca.mcmaster.se2aa4.mazerunner;

/**
 * Represents a position in the maze defined by a row and column.
 * Supports directional movement and comparison.
 * 
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /**
     * Returns a new position moved in the specified direction.
     *
     * @param dir The direction to move in.
     * @return The new position after moving.
     */
    public Position move(Direction dir) {
        int newRow = row;
        int newCol = col;

        switch (dir) {
            case UP -> newRow = Math.max(0, row - 1);
            case DOWN -> newRow = row + 1;
            case LEFT -> newCol = Math.max(0, col - 1);
            case RIGHT -> newCol = col + 1;
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
