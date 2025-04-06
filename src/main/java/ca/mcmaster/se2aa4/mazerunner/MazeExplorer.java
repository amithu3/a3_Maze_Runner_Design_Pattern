package ca.mcmaster.se2aa4.mazerunner;

/**
 * Provides navigation-related utilities for exploring the maze.
 * Finds entry/exit and validates valid movement positions.
 * 
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class MazeExplorer {
    private final Maze maze;
    private final Position entry;
    private final Position exit;

    /**
     * Initializes the explorer with a maze and finds entry/exit.
     *
     * @param maze The maze to explore.
     */
    public MazeExplorer(Maze maze) {
        this.maze = maze;
        this.entry = findEntry();
        this.exit = findExit();

        if (entry == null || exit == null) {
            throw new RuntimeException("Invalid maze: No entry or exit found.");
        }
    }

    /**
     * Finds the maze entry point (first column).
     *
     * @return The entry position or null if not found.
     */
    private Position findEntry() {
        for (int i = 0; i < maze.getRowCount(); i++) {
            if (maze.getCell(i, 0) == ' ') {
                return new Position(i, 0);
            }
        }
        return null;
    }

    /**
     * Finds the maze exit point (last column).
     *
     * @return The exit position or throws error if not found.
     */
    private Position findExit() {
        int rowCount = maze.getRowCount();
        int colCount = maze.getMaxCol();

        for (int row = 0; row < rowCount; row++) {
            if (maze.getCell(row, colCount - 1) == ' ') {
                return new Position(row, colCount - 1);
            }
        }

        throw new RuntimeException("No exit found in the rightmost column");
    }

    public Position getEntry() {
        return entry;
    }

    public Position getExit() {
        return exit;
    }

    /**
     * Checks whether a position is within the maze and not a wall.
     *
     * @param pos The position to check.
     * @return True if the position is valid and not a wall.
     */
    public boolean isValidPosition(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();

        if (row < 0 || row >= maze.getRowCount()) return false;
        if (col < 0 || col >= maze.getColCount(row)) return false;

        return maze.getCell(row, col) != '#';
    }
}
