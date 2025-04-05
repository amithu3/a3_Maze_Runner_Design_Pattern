package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.commands.Command;
import ca.mcmaster.se2aa4.mazerunner.utils.PathFormatter;
import ca.mcmaster.se2aa4.mazerunner.commands.MoveForwardCommand;
import ca.mcmaster.se2aa4.mazerunner.commands.TurnLeftCommand;
import ca.mcmaster.se2aa4.mazerunner.commands.TurnRightCommand;

public class RightHandSolver implements MazeSolver {
    @Override
    public String solve(Maze maze) {
        MazeExplorer explorer;
        try {
            explorer = new MazeExplorer(maze);
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
            return "";
        }

        Position currentPosition = explorer.getEntry();
        Position end = explorer.getExit();
        Direction direction = Direction.RIGHT;
        StringBuilder path = new StringBuilder();

        if (currentPosition == null || end == null) {
            System.out.println("ERROR: Could not find start or end position!");
            return "";
        }

        Explorer temp = new Explorer(currentPosition, direction);

        while (!currentPosition.equals(end)) {
            Direction dir = temp.getDirection();

            if (explorer.isValidPosition(temp.getPosition().move(dir.turnRight()))) {
                new TurnRightCommand(temp).execute();
                path.append('R');

                new MoveForwardCommand(temp, explorer).execute();
                path.append('F');
            } else if (explorer.isValidPosition(temp.getPosition().move(dir))) {
                new MoveForwardCommand(temp, explorer).execute();
                path.append('F');
            } else if (explorer.isValidPosition(temp.getPosition().move(dir.turnLeft()))) {
                new TurnLeftCommand(temp).execute();
                path.append('L');

                new MoveForwardCommand(temp, explorer).execute();
                path.append('F');
            } else {
                new TurnRightCommand(temp).execute();
                new TurnRightCommand(temp).execute();
                path.append("RR");
            }

            direction = temp.getDirection();
            currentPosition = temp.getPosition();
        }

        System.out.println("Canonical form: " + path.toString());
        System.out.println("Factorized form: " + PathFormatter.getFactorizedPath(path.toString()));

        return path.toString();
    }
}
