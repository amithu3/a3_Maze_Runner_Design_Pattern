package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {
    private final MazeExplorer explorer;

    public PathValidator(Maze maze) {
        this.explorer = new MazeExplorer(maze);  
    }

    public boolean validatePath(String path) {
        Position position = explorer.getEntry(); 
        Direction direction = Direction.RIGHT;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F' -> position = position.move(direction);
                case 'L' -> direction = direction.turnLeft();
                case 'R' -> direction = direction.turnRight();
                default -> {
                    return false;
                }
            }

            if (!explorer.isValidPosition(position)) return false;  
        }
        return position.equals(explorer.getExit());  
    }
}
