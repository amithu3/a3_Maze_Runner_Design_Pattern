package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.commands.Command;
import ca.mcmaster.se2aa4.mazerunner.Explorer;
import ca.mcmaster.se2aa4.mazerunner.MazeExplorer;
import ca.mcmaster.se2aa4.mazerunner.commands.MoveForwardCommand;
import ca.mcmaster.se2aa4.mazerunner.commands.TurnLeftCommand;
import ca.mcmaster.se2aa4.mazerunner.commands.TurnRightCommand;

public class PathValidator {
    private final MazeExplorer explorer;

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
