package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class RightHandSolver implements MazeSolver {
    @Override
    public String solve(Maze maze) {
        MazeExplorer explorer;
        try {
            explorer = new MazeExplorer(maze);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return "";
        }

        Position currentPosition = explorer.getEntry();
        Position end = explorer.getExit();
        Direction dir = Direction.RIGHT;
        StringBuilder path = new StringBuilder();

        if (currentPosition == null || end == null) {
            System.out.println("ERROR: Could not find start or end position!");
            return "";
        }

        while (!currentPosition.equals(end)) {
            Position rightPos = currentPosition.move(dir.turnRight());
            Position forwardPos = currentPosition.move(dir);
            Position leftPos = currentPosition.move(dir.turnLeft());

            if (explorer.isValidPosition(rightPos)) {
                dir = dir.turnRight();
                path.append('R');
                currentPosition = currentPosition.move(dir);
                path.append('F');
            } else if (explorer.isValidPosition(forwardPos)) {
                currentPosition = forwardPos;
                path.append('F');
            } else if (explorer.isValidPosition(leftPos)) {
                dir = dir.turnLeft();
                path.append('L');
                currentPosition = currentPosition.move(dir);
                path.append('F');
            } else {
                dir = dir.turnRight().turnRight();
                path.append("RR");
            }
        }

        return path.toString();
    }
}
