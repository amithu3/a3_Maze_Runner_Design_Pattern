package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Explorer class.
 * Verifies turning behavior and initial position storage.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class ExplorerTest {

    /**
     * Tests turning left from an initial UP direction.
     */
    @Test
    public void testTurnLeft() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.UP);
        explorer.turnLeft();
        assertEquals(Direction.LEFT, explorer.getDirection());
    }

    /**
     * Tests turning right from an initial UP direction.
     */
    @Test
    public void testTurnRight() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.UP);
        explorer.turnRight();
        assertEquals(Direction.RIGHT, explorer.getDirection());
    }

    /**
     * Ensures that getPosition() returns the initial position.
     */
    @Test
    public void testGetPosition() {
        Explorer explorer = new Explorer(new Position(2, 3), Direction.RIGHT);
        Position expectedPosition = new Position(2, 3);
        assertEquals(expectedPosition, explorer.getPosition());
    }

    /**
     * Tests turning right from DOWN direction.
     */
    @Test
    public void testTurnRightFromDown() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.DOWN);
        explorer.turnRight();
        assertEquals(Direction.LEFT, explorer.getDirection());
    }

    /**
     * Tests turning left from RIGHT direction.
     */
    @Test
    public void testTurnLeftFromRight() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.RIGHT);
        explorer.turnLeft();
        assertEquals(Direction.UP, explorer.getDirection());
    }
}
