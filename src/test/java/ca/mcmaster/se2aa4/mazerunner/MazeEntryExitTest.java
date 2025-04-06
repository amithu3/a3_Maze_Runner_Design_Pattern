package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for validating correct detection of entry and exit points
 * in various maze configurations.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class MazeEntryExitTest {

    /**
     * Helper method to convert string rows into a Maze instance.
     */
    private Maze createMazeFromStrings(String... rows) {
        List<char[]> mazeRows = Arrays.stream(rows)
            .map(String::toCharArray)
            .toList();
        return new Maze(mazeRows);
    }

    /**
     * Tests that the entry and exit are correctly identified in a simple maze.
     */
    @Test
    public void testSimpleMazeEntryExit() {
        Maze maze = createMazeFromStrings(
            "#### ####",
            "#       #",
            "   ##### "
        );
        MazeExplorer explorer = new MazeExplorer(maze);
        assertEquals(new Position(2, 0), explorer.getEntry());
        assertEquals(new Position(2, 8), explorer.getExit());
    }

    /**
     * Tests entry in a middle row and exit in the last column of the same row.
     */
    @Test
    public void testEntryInMiddleRowExitInBottomRow() {
        Maze maze = createMazeFromStrings(
            "#########",
            "   ##### ",
            "#   #####"
        );
        MazeExplorer explorer = new MazeExplorer(maze);
        assertEquals(new Position(1, 0), explorer.getEntry());
        assertEquals(new Position(1, 8), explorer.getExit());
    }

    /**
     * Tests that if no exit is found, an exception is thrown.
     */
    @Test
    public void testOnlyFirstOpeningUsedForEntry() {
        Maze maze = createMazeFromStrings(
            "   ######",
            "   ######",
            "   ######"
        );
        Exception exception = assertThrows(RuntimeException.class, () -> new MazeExplorer(maze));
        assertEquals("No exit found in the rightmost column", exception.getMessage());
    }

    /**
     * Tests when entry and exit are on the same row but at opposite ends.
     */
    @Test
    public void testEntryAndExitSameRow() {
        Maze maze = createMazeFromStrings(
            "#########",
            "        #",
            "######## "
        );
        MazeExplorer explorer = new MazeExplorer(maze);
        assertEquals(new Position(1, 0), explorer.getEntry());
        assertEquals(new Position(2, 8), explorer.getExit());
    }
}
