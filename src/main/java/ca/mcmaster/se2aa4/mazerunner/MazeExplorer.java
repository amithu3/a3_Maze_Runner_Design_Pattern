package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class MazeExplorer {
    private final Maze maze;
    private final Position entry;
    private final Position exit;

    public MazeExplorer(Maze maze) throws IOException {
        this.maze = maze;
        this.entry = findEntry();
        this.exit = findExit();

        if (entry == null || exit == null) {
            throw new IOException("Invalid maze: No entry or exit found.");
        }
    }

    private Position findEntry() {
        char[][] grid = maze.getGrid();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == ' ') {
                return new Position(i, 0);
            }
        }
        return null;
    }
    
    private Position findExit() {
        char[][] grid = maze.getGrid();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] == ' ') {
                return new Position(i, grid[0].length - 1);
            }
        }
        System.out.println("ERROR: No exit point found!");
        return null;
    }
    
    public Position getEntry() { return entry; } 
    public Position getExit() { return exit; }    

    public boolean isValidPosition(Position pos) { 
        char[][] grid = maze.getGrid();
        int row = pos.getRow();
        int col = pos.getCol();
        return row >= 0 && row < grid.length &&
               col >= 0 && col < grid[0].length &&
               grid[row][col] != '#';  // Assuming '#' is a wall
    }
}
