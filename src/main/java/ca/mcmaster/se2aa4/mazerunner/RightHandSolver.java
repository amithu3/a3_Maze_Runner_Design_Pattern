package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {

    @Override
    public String solve(Maze maze) {
        Position pos = maze.getStart();
        Direction dir = Direction.RIGHT;
        StringBuilder path = new StringBuilder();

        while (!pos.equals(maze.getEnd())) {
            if (maze.isValidPosition(pos.move(dir.turnRight()))) {
                dir = dir.turnRight();
                path.append('R');
            } else if (maze.isValidPosition(pos.move(dir))) {
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
