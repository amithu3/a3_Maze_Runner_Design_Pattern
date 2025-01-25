package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {

    private char[][] maze;

    public PathValidator(char[][] maze) {
        if (maze == null || maze.length == 0) {
            throw new IllegalArgumentException("Maze cannot be null or empty.");
        }
        this.maze = maze;
    }

    public boolean validatePath(String path) {
        int[] currentPosition = findEntryPoint();
        if (currentPosition == null) {
            System.err.println("No entry point found in the maze!");
            return false;
        }

        System.out.println(
                "Starting validation from entry point: (" + currentPosition[0] + ", " + currentPosition[1] + ")");
        System.out.println("Path to validate: " + path);

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'U':
                    currentPosition[0]--;
                    break;
                case 'D':
                    currentPosition[0]++;
                    break;
                case 'L':
                    currentPosition[1]--;
                    break;
                case 'R':
                    currentPosition[1]++;
                    break;
                default:
                    System.err.println("Invalid move: " + move);
                    return false;
            }

            if (!isValidPosition(currentPosition[0], currentPosition[1])) {
                System.err.println("Invalid path! Hit a wall or went out of bounds at position: ("
                        + currentPosition[0] + ", " + currentPosition[1] + ")");
                return false;
            }

            if (maze[currentPosition[0]][currentPosition[1]] == 'X') {
                System.out.println("Path is valid! Exit reached at position: (" + currentPosition[0] + ", "
                        + currentPosition[1] + ")");
                return true;
            }
        }

        System.err.println("Path validation failed! Exit was not reached.");
        return false;
    }

    public String solveStraightPath() {
        int[] entry = findEntryPoint();
        int[] exit = findExitPoint();

        if (entry == null || exit == null) {
            throw new IllegalStateException("Entry or exit point not found in the maze.");
        }

        StringBuilder path = new StringBuilder();
        int rowDiff = exit[0] - entry[0];
        int colDiff = exit[1] - entry[1];

        for (int i = 0; i < Math.abs(rowDiff); i++) {
            path.append(rowDiff > 0 ? "D" : "U");
        }

        for (int i = 0; i < Math.abs(colDiff); i++) {
            path.append(colDiff > 0 ? "R" : "L");
        }

        System.out.println("Path to solve straight maze: " + path);
        return path.toString();
    }

    private int[] findEntryPoint() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'E') {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private int[] findExitPoint() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'X') {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < maze.length &&
                col >= 0 && col < maze[0].length &&
                maze[row][col] != '#';
    }
}
