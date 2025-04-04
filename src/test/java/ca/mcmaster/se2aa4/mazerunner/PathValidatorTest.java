package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathValidatorTest {

    private Maze createSimpleMaze() {
        // Simple 3x3 maze:
        // E = Entry (at (1, 0)), X = Exit (at (1, 2)), # = Wall, ' ' = Open path
        // [#, #, #]
        // [E,  , X]
        // [#, #, #]
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

        assertFalse(validator.validatePath("F")); // E -> (1,1), not yet at exit
    }

    @Test
    public void testInvalidPath_HitsWall() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);

        assertFalse(validator.validatePath("RFF")); // Turning right then moving into wall
    }

    @Test
    public void testInvalidPath_OffGrid() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);

        assertFalse(validator.validatePath("FFFF")); // Goes beyond maze boundary
    }

    @Test
    public void testInvalidPath_BadCharacter() {
        Maze maze = createSimpleMaze();
        PathValidator validator = new PathValidator(maze);

        assertFalse(validator.validatePath("FZ")); // 'Z' is invalid command
    }

}
