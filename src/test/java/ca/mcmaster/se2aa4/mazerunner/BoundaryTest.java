package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests boundary movement logic for the Position class,
 * ensuring that moving outside the grid limits does not cause errors.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class BoundaryTest {

    /**
     * Ensures that moving UP or LEFT from the top-left corner does not exceed bounds.
     */
    @Test
    public void testUpperLeftBoundary() {
        Position start = new Position(0, 0);
        assertEquals(new Position(0, 0), start.move(Direction.UP));
        assertEquals(new Position(0, 0), start.move(Direction.LEFT));
    }

    /**
     * Checks that moving DOWN from a lower position increases the row index.
     */
    @Test
    public void testLowerBoundary() {
        Position start = new Position(10, 5);
        assertEquals(new Position(11, 5), start.move(Direction.DOWN));
    }

    /**
     * Checks that moving RIGHT from a position increases the column index.
     */
    @Test
    public void testRightBoundary() {
        Position start = new Position(5, 10);
        assertEquals(new Position(5, 11), start.move(Direction.RIGHT));
    }
}
