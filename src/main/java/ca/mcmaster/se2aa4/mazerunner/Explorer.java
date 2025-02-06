package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private Position position;
    private Direction direction;

    public Explorer(Position startPosition, Direction startDirection) {
        this.position = startPosition;
        this.direction = startDirection;
    }

    public void moveForward(MazeExplorer explorer) {
        Position nextPos = position.move(direction);
        if (explorer.isValidPosition(nextPos)) {
            position = nextPos;
        }
    }
    

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
