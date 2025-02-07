/**
 * @author Midhousha Anura
 * @course SFWRENG 2AA4
 * @assignment A1 - Maze Runner
 * @date Feb 1, 2025
 * 
 * The PathValidator class is responsible for validating a given path
 * in a maze. It ensures that the path follows valid movements and
 * reaches the maze exit correctly.
 */
package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {
    private final MazeExplorer explorer;

    /**
     * Constructor initializes the PathValidator with a given maze.
     * If the maze is invalid, the explorer is set to null.
     * 
     * @param maze The maze in which the path validation will occur.
     */
    public PathValidator(Maze maze) {
        MazeExplorer tempExplorer;
        try {
            tempExplorer = new MazeExplorer(maze);  
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            tempExplorer = null;  // Set to null if an error occurs
        }
        this.explorer = tempExplorer;
    }

    /**
     * Validates a given path to determine whether it correctly navigates
     * through the maze from entry to exit while following valid movements.
     * 
     * @param path A string representing the movement path, using:
     *             'F' for moving forward,
     *             'L' for turning left,
     *             'R' for turning right.
     * @return true if the path is valid and leads to the exit, false otherwise.
     */
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
                    return false; // Invalid character in path
                }
            }

            // If the new position is invalid, return false
            if (!explorer.isValidPosition(position)) return false;
        }
        
        // Return true if the final position matches the maze exit
        return position.equals(explorer.getExit());
    }
}
