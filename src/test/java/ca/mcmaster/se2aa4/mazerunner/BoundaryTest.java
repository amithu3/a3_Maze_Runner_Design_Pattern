package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundaryTest {
    @Test
    public void testUpperLeftBoundary() {
        Position start = new Position(0, 0);
        assertEquals(new Position(0, 0), start.move(Direction.UP));
        assertEquals(new Position(0, 0), start.move(Direction.LEFT));
    }

    @Test
    public void testLowerBoundary() {
        Position start = new Position(10, 5);
        assertEquals(new Position(11, 5), start.move(Direction.DOWN));
    }

    @Test
    public void testRightBoundary() {
        Position start = new Position(5, 10);
        assertEquals(new Position(5, 11), start.move(Direction.RIGHT));
    }
}
