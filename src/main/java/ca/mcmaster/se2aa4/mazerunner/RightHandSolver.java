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

        Position start = explorer.getEntry();
        Position end = explorer.getExit();

        if (start == null || end == null) {
            System.out.println("ERROR: Could not find start or end position!");
            return "";
        }

        Explorer player = new Explorer(start, Direction.RIGHT);
        StringBuilder path = new StringBuilder();

        while (!player.getPosition().equals(end)) {
            Position rightPos = player.getPosition().move(player.getDirection().turnRight());
            Position forwardPos = player.getPosition().move(player.getDirection());

            if (explorer.isValidPosition(rightPos)) {
                player.turnRight();
                player.moveForward(explorer);
                path.append('R').append('F');
            } else if (explorer.isValidPosition(forwardPos)) {
                player.moveForward(explorer);
                path.append('F');
            } else {
                player.turnLeft();
                path.append('L');
            }
        }

        return path.toString();
    }
}
