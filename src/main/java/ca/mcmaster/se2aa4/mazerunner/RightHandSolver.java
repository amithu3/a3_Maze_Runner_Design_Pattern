package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {

    @Override
    public String solve(Maze maze) {
        MazeExplorer explorer = new MazeExplorer(maze);  // Use MazeExplorer
        Position pos = explorer.getEntry();  // Get start position
        Position end = explorer.getExit();   // Get end position

        Direction dir = Direction.RIGHT;
        StringBuilder path = new StringBuilder();

        while (!pos.equals(end)) {
            if (explorer.isValidPosition(pos.move(dir.turnRight()))) {  // Use explorer
                dir = dir.turnRight();
                path.append('R');
            } else if (explorer.isValidPosition(pos.move(dir))) {
                path.append('F');
            } else {
                dir = dir.turnLeft();
                path.append('L');
            }
            pos = pos.move(dir);
        }
        return path.toString();
    }
}
