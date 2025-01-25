package ca.mcmaster.se2aa4.mazerunner;

public class MazeExplorer {

    private char[][] maze;

    public MazeExplorer(char[][] maze) {
        if (maze == null || maze.length == 0) {
            throw new IllegalArgumentException("Maze cannot be null or empty.");
        }
        this.maze = maze;
    }

    public int[][] findEntryAndExit() {
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] entryExitPoints = new int[2][2];
        boolean entryFound = false, exitFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!entryFound && isBoundary(i, j, rows, columns) && maze[i][j] == 'E') {
                    entryExitPoints[0] = new int[] { i, j };
                    entryFound = true;
                }
                if (!exitFound && isBoundary(i, j, rows, columns) && maze[i][j] == 'X') {
                    entryExitPoints[1] = new int[] { i, j };
                    exitFound = true;
                }

                if (entryFound && exitFound) {
                    return entryExitPoints;
                }
            }
        }

        if (!entryFound) {
            throw new IllegalArgumentException("No entry point (E) found in the maze.");
        }
        if (!exitFound) {
            throw new IllegalArgumentException("No exit point (X) found in the maze.");
        }

        return entryExitPoints;
    }

    private boolean isBoundary(int row, int col, int rows, int columns) {
        return row == 0 || row == rows - 1 || col == 0 || col == columns - 1;
    }

    public char[][] getMaze() {
        return maze;
    }
}
