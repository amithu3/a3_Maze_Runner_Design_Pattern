package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MazeExplorer class.
 * Verifies path validity checks and entry/exit detection.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
class MazeExplorerTest {

    /**
     * Helper to construct a maze from string rows.
     */
    private Maze buildMaze(String... rows) {
        List<char[]> grid = new ArrayList<>();
        for (String row : rows) {
            grid.add(row.toCharArray());
        }
        return new Maze(grid);
    }

    /**
     * Tests that a known valid open space is recognized.
     */
    @Test
    void testValidPositionInsideMaze() {
        Maze maze = buildMaze(
            " # ",
            "###",
            "# #"
        );

        MazeExplorer explorer = new MazeExplorer(maze);
        Position pos = new Position(0, 2);
        assertTrue(explorer.isValidPosition(pos));
    }

    /**
     * Tests that positions beyond the maze bounds are marked invalid.
     */
    @Test
    void testInvalidPositionOutOfBounds() {
        Maze maze = buildMaze(
            " # ",
            "# #"
        );

        MazeExplorer explorer = new MazeExplorer(maze);

        assertFalse(explorer.isValidPosition(new Position(-1, 0)));
        assertFalse(explorer.isValidPosition(new Position(0, 10)));
        assertFalse(explorer.isValidPosition(new Position(10, 0)));
    }

    /**
     * Tests that walls (marked with #) are not considered valid positions.
     */
    @Test
    void testWallIsInvalidPosition() {
        Maze maze = buildMaze(
            " # ",
            "###"
        );

        MazeExplorer explorer = new MazeExplorer(maze);
        assertFalse(explorer.isValidPosition(new Position(1, 1)));
    }

    /**
     * Tests entry and exit detection when multiple entry-like spaces exist.
     */
    @Test
    void testMultipleOpeningsOnlyFirstIsUsedForEntry() {
        Maze maze = buildMaze(
            "  ##",
            "# # ",
            "   #"
        );

        MazeExplorer explorer = new MazeExplorer(maze);
        assertEquals(new Position(0, 0), explorer.getEntry());
        assertEquals(new Position(1, 3), explorer.getExit());
    }
}
