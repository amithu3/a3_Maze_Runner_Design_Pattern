package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testMove() {
        Position start = new Position(2, 2);

        assertEquals(new Position(1, 2), start.move(Direction.UP));    // Moves up
        assertEquals(new Position(3, 2), start.move(Direction.DOWN));  // Moves down
        assertEquals(new Position(2, 1), start.move(Direction.LEFT));  // Moves left
        assertEquals(new Position(2, 3), start.move(Direction.RIGHT)); // Moves right
    }

    @Test
    public void testEquals() {
        Position p1 = new Position(3, 4);
        Position p2 = new Position(3, 4);
        Position p3 = new Position(4, 3);

        assertEquals(p1, p2); 
        assertNotEquals(p1, p3);
    }

    @Test
    public void testMoveAtBoundaries() {
        Position topLeft = new Position(0, 0);
        Position bottomLeft = new Position(10, 0); 

        assertEquals(new Position(0, 0), topLeft.move(Direction.UP));    // Stays at (0,0)
        assertEquals(new Position(0, 0), topLeft.move(Direction.LEFT));  // Stays at (0,0)
        assertEquals(new Position(1, 0), topLeft.move(Direction.DOWN));  
        assertEquals(new Position(0, 1), topLeft.move(Direction.RIGHT));
        assertEquals(new Position(11, 0), bottomLeft.move(Direction.DOWN));
    }
}
