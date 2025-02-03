package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Position;

public class Explorer {
    private Position position;
    private Direction direction;

    public Explorer(Position startPosition, Direction startDirection) {
        this.position = startPosition;
        this.direction = startDirection;
    }

    public void moveForward() {
        position = position.move(direction);
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
