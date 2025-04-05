package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.Explorer;
import ca.mcmaster.se2aa4.mazerunner.MazeExplorer;

public class MoveForwardCommand implements Command {
    private final Explorer explorer;
    private final MazeExplorer maze;

    public MoveForwardCommand(Explorer explorer, MazeExplorer maze) {
        this.explorer = explorer;
        this.maze = maze;
    }

    @Override
    public void execute() {
        explorer.moveForward(maze);
    }
}
