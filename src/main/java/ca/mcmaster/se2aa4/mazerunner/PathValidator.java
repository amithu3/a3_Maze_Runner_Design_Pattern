package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Position;

public class PathValidator {

    private final char[][] maze;

    public PathValidator(char[][] maze) {
        this.maze = maze;
    }

    public boolean validatePath(String path) {
        Position position = new MazeExplorer(maze).findEntry();
        Direction direction = Direction.RIGHT;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F' -> {
                    position = position.move(direction);
                }
                case 'L' -> {
                    direction = direction.turnLeft();
                }
                case 'R' -> {
                    direction = direction.turnRight();
                }
                default -> {
                    return false;
                }
            }

            if (!isValidPosition(position)) return false;
        }
        return maze[position.y()][position.x()] == ' ';
    }

    private boolean isValidPosition(Position pos) {
        return pos.x() >= 0 && pos.x() < maze[0].length && pos.y() >= 0 && pos.y() < maze.length && maze[pos.y()][pos.x()] != '#';
    }
}
