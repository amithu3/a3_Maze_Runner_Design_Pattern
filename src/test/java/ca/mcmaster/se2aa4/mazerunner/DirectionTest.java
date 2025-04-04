package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testTurnLeft() {
        assertEquals(Direction.LEFT, Direction.UP.turnLeft());
        assertEquals(Direction.DOWN, Direction.LEFT.turnLeft());
        assertEquals(Direction.RIGHT, Direction.DOWN.turnLeft());
        assertEquals(Direction.UP, Direction.RIGHT.turnLeft());
    }

    @Test
    public void testTurnRight() {
        assertEquals(Direction.RIGHT, Direction.UP.turnRight());
        assertEquals(Direction.DOWN, Direction.RIGHT.turnRight());
        assertEquals(Direction.LEFT, Direction.DOWN.turnRight());
        assertEquals(Direction.UP, Direction.LEFT.turnRight());
    }

    @Test
    public void testFullRotationLeft() {
        Direction initial = Direction.UP;
        Direction after360 = initial.turnLeft().turnLeft().turnLeft().turnLeft();
        assertEquals(initial, after360, "4 left turns should return to original direction");
    }

    @Test
    public void testFullRotationRight() {
        Direction initial = Direction.RIGHT;
        Direction after360 = initial.turnRight().turnRight().turnRight().turnRight();
        assertEquals(initial, after360, "4 right turns should return to original direction");
    }

    @Test
    public void testOppositeDirection() {
        assertEquals(Direction.DOWN, Direction.UP.turnLeft().turnLeft());
        assertEquals(Direction.UP, Direction.DOWN.turnRight().turnRight());
        assertEquals(Direction.RIGHT, Direction.LEFT.turnLeft().turnLeft());
        assertEquals(Direction.LEFT, Direction.RIGHT.turnRight().turnRight());
    }

    @Test
    public void testMixedTurns() {
        // Test that left and right turns cancel each other out
        Direction initial = Direction.DOWN;
        Direction afterTurns = initial.turnLeft().turnRight().turnRight().turnLeft();
        assertEquals(initial, afterTurns, "Mixed turns should cancel out");

        // Test specific mixed turn sequences
        assertEquals(Direction.UP, Direction.RIGHT.turnLeft().turnLeft().turnRight());
        assertEquals(Direction.LEFT, Direction.DOWN.turnRight().turnLeft().turnRight());
    }

    @Test
    public void testDirectionEquality() {
        // Test that each direction is equal to itself
        for (Direction dir : Direction.values()) {
            assertEquals(dir, dir);
        }

        // Test that different directions are not equal
        assertNotEquals(Direction.UP, Direction.DOWN);
        assertNotEquals(Direction.LEFT, Direction.RIGHT);
    }

    @Test
    public void testToString() {
        assertEquals("UP", Direction.UP.toString());
        assertEquals("RIGHT", Direction.RIGHT.toString());
        assertEquals("DOWN", Direction.DOWN.toString());
        assertEquals("LEFT", Direction.LEFT.toString());
    }
}