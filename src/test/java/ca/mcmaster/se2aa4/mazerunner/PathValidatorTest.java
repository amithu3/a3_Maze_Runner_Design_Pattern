package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PathValidator class.
 * Validates movement logic, path validation, and error handling.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class PathValidatorTest {

    /**
     * Constructs a simple maze for validation tests.
     * E = Entry (1, 0), X = Exit (1, 2), Walls = '#'
     */
    private Maze createSimpleMaze() {
        List<char[]> grid = List.of(
            "# #".toCharArray(),
            "E X".toCharArray(),
            "###".toCharArray()
        );
        return new Maze(grid);
    }

    @Test
    public void testInvalidPath_TooShort() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);
        assertFalse(validator.validatePath("F"));
    }

    @Test
    public void testInvalidPath_HitsWall() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);
        assertFalse(validator.validatePath("RFF"));
    }

    @Test
    public void testInvalidPath_OffGrid() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);
        assertFalse(validator.validatePath("FFFF"));
    }

    @Test
    public void testInvalidPath_BadCharacter() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);
        assertFalse(validator.validatePath("FZ"));
    }
}
