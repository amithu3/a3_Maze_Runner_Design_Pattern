package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MazeEntryExitTest {

    private Maze createMazeFromStrings(String... rows) {
        List<char[]> mazeRows = Arrays.stream(rows)
            .map(String::toCharArray)
            .toList();
        return new Maze(mazeRows);
    }

    @Test
    public void testSimpleMazeEntryExit() {
        Maze maze = createMazeFromStrings(
            "#### ####",
            "#       #",
            "   ##### "
        );
        MazeExplorer explorer = new MazeExplorer(maze);
        assertEquals(new Position(2, 0), explorer.getEntry());
        assertEquals(new Position(2, 8), explorer.getExit());  // FIXED
    }

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

    @Test
    public void testOnlyFirstOpeningUsedForEntry() {
        Maze maze = createMazeFromStrings(
            "   ######",
            "   ######",
            "   ######"
        );
        Exception exception = assertThrows(RuntimeException.class, () -> new MazeExplorer(maze));
        assertEquals("No exit found in the rightmost column", exception.getMessage());  // FIXED
    }

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
