package ca.mcmaster.se2aa4.mazerunner;


public class RightHandSolver implements MazeSolver {
    @Override
    public String solve(Maze maze) {
        MazeExplorer explorer;
        try {
            explorer = new MazeExplorer(maze);  
        } catch (RuntimeException e) {  // Fix: Catch RuntimeException, not IOException
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

        while (!currentPosition.equals(end)) {
            if (explorer.isValidPosition(currentPosition.move(direction.turnRight()))) {
                // Turn right and move forward if valid
                direction = direction.turnRight();
                path.append('R');
                currentPosition = currentPosition.move(direction);
                path.append('F');
            } else {
                if (explorer.isValidPosition(currentPosition.move(direction))) {
                    // Move forward if valid
                    currentPosition = currentPosition.move(direction);
                    path.append('F');
                } else if (explorer.isValidPosition(currentPosition.move(direction.turnLeft()))) {
                    // Turn left and move forward if valid
                    direction = direction.turnLeft();
                    path.append('L');
                    currentPosition = currentPosition.move(direction);
                    path.append('F');
                } else {
                    // Turn around
                    direction = direction.turnRight().turnRight();
                    path.append('R');
                    path.append('R');
                }
            }
        }
        

        return path.toString();
    }

}
