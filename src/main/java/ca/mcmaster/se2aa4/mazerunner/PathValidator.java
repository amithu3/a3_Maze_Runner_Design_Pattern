package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class PathValidator {
    private final MazeExplorer explorer;

    public PathValidator(Maze maze) {
        MazeExplorer tempExplorer;
        try {
            tempExplorer = new MazeExplorer(maze);  
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            tempExplorer = null;  // Set to null if an error occurs
        }
        this.explorer = tempExplorer;
    }

    public boolean validatePath(String path) {
        if (explorer == null) {
            System.out.println("ERROR: MazeExplorer could not be created.");
            return false;
        }

        Position position = explorer.getEntry();
        Direction direction = Direction.RIGHT;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F' -> position = position.move(direction);
                case 'L' -> direction = direction.turnLeft();
                case 'R' -> direction = direction.turnRight();
                default -> {
                    return false;
                }
            }

            if (!explorer.isValidPosition(position)) return false;
        }
        return position.equals(explorer.getExit());
    }
}
