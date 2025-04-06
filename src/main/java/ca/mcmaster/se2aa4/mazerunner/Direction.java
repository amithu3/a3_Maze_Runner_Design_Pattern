package ca.mcmaster.se2aa4.mazerunner;

/**
 * Represents possible movement directions in the maze.
 * Provides methods to turn left or right relative to the current direction.
 * 
 * @author Midhousha Anura
 * @assignment 2AA4 Assignment 3
 * @date March 31, 2025
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    /**
     * Returns the direction obtained after turning left from the current direction.
     *
     * @return The new direction after turning left.
     */
    public Direction turnLeft() {
        return switch (this) {
            case UP -> LEFT;
            case LEFT -> DOWN;
            case DOWN -> RIGHT;
            case RIGHT -> UP;
        };
    }

    /**
     * Returns the direction obtained after turning right from the current direction.
     *
     * @return The new direction after turning right.
     */
    public Direction turnRight() {
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }
}
