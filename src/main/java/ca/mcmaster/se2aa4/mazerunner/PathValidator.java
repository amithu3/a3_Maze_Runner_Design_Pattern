package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.commands.*;

/**
 * Validates a given path string to determine whether it correctly navigates
 * from the maze's entry to the exit using valid moves.
 * 
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class PathValidator {
    private final MazeExplorer explorer;

    /**
     * Initializes the validator using the given maze.
     *
     * @param maze The maze to validate paths against.
     */
    public PathValidator(Maze maze) {
        MazeExplorer tempExplorer;
        try {
            tempExplorer = new MazeExplorer(maze);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            tempExplorer = null;
        }
        this.explorer = tempExplorer;
    }

    /**
     * Validates a movement path by simulating each move from the entry point.
     *
     * @param path A string of moves ('F', 'L', 'R') to follow.
     * @return True if the path is valid and ends at the maze exit.
     */
    public boolean validatePath(String path) {
        if (explorer == null) {
            System.out.println("ERROR: MazeExplorer could not be created.");
            return false;
        }

        Explorer temp = new Explorer(explorer.getEntry(), Direction.RIGHT);

        for (char move : path.toCharArray()) {
            Command command;
            switch (move) {
                case 'F' -> command = new MoveForwardCommand(temp, explorer);
                case 'L' -> command = new TurnLeftCommand(temp);
                case 'R' -> command = new TurnRightCommand(temp);
                default -> {
                    return false;
                }
            }
            command.execute();

            if (!explorer.isValidPosition(temp.getPosition())) return false;
        }

        return temp.getPosition().equals(explorer.getExit());
    }
}
