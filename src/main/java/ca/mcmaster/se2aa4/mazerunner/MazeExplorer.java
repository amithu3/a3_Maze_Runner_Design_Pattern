package ca.mcmaster.se2aa4.mazerunner;

public class MazeExplorer {
    private final Maze maze;
    private final Position entry;
    private final Position exit;

    public MazeExplorer(Maze maze) {
        this.maze = maze;
        this.entry = findEntry();
        this.exit = findExit();

        if (entry == null || exit == null) {
            throw new RuntimeException("Invalid maze: No entry or exit found.");
        }
    }

    private Position findEntry() {
        for (int i = 0; i < maze.getRowCount(); i++) {
            if (maze.getCell(i, 0) == ' ') { // Check first column of each row
                return new Position(i, 0);
            }
        }
        return null;
    }

    
    private Position findExit() {
        maze.printMaze();  // Debug: Print maze to ensure it's read correctly
        
        int rowCount = maze.getRowCount();
        int colCount = maze.getMaxCol();  // Ensure this gives the last column index + 1
    
    
        // Iterate through each row in the last column
        for (int row = 0; row < rowCount; row++) {
            if (maze.getCell(row, colCount - 1) == ' ') {  // Check if it's an empty space
                return new Position(row, colCount - 1);
            }
        }
    
        throw new RuntimeException("No exit found in the rightmost column");
    }
    
    
    
    
    
    
    
    

    public Position getEntry() { return entry; } 
    public Position getExit() { return exit; }    

    public boolean isValidPosition(Position pos) { 
        int row = pos.getRow();
        int col = pos.getCol();

        // Ensure row index is within bounds
        if (row < 0 || row >= maze.getRowCount()) return false;

        // Ensure column index is within bounds for that specific row
        if (col < 0 || col >= maze.getColCount(row)) return false;

        return maze.getCell(row, col) != '#';  // Assuming '#' is a wall
    }
}
