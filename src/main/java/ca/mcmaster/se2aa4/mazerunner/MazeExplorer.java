package ca.mcmaster.se2aa4.mazerunner;

public class MazeExplorer {

    private char[][] maze;

    public MazeExplorer(char[][] maze) {
        if (maze == null || maze.length == 0) {
            throw new IllegalArgumentException("Maze cannot be null or empty.");
        }
        this.maze = maze;
    }

    public Position findEntry() {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == ' ') return new Position(0, i);
        }
        throw new IllegalArgumentException("No valid entry found");
    }

    public Position findExit() {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][maze[0].length - 1] == ' ') return new Position(maze[0].length - 1, i);
        }
        throw new IllegalArgumentException("No valid exit found");
    }
}
