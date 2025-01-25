package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private int x;
    private int y;
    private Direction direction;

    // Constructor to initialize position and direction
    public Explorer(int startX, int startY, Direction startDirection) {
        this.x = startX;
        this.y = startY;
        this.direction = startDirection;
    }

    public void moveForward() {
        switch (direction) {
            case NORTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y++;
                break;
            case WEST:
                x--;
                break;
        }
        printPosition();
    }

    public void turnLeft() {
        direction = Direction.values()[(direction.ordinal() + 3) % 4];
    }

    public void turnRight() {
        direction = Direction.values()[(direction.ordinal() + 1) % 4];
    }

    public void printPosition() {
        System.out.println("Explorer is at (" + x + ", " + y + "), facing " + direction);
    }
}
