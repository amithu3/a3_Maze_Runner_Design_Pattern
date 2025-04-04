package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MazeExplorerTest {

    private Maze buildMaze(String... rows) {
        List<char[]> grid = new ArrayList<>();
        for (String row : rows) {
            grid.add(row.toCharArray());
        }
        return new Maze(grid);
    }

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

    @Test
    void testWallIsInvalidPosition() {
        Maze maze = buildMaze(
            " # ",
            "###"
        );

        MazeExplorer explorer = new MazeExplorer(maze);

        assertFalse(explorer.isValidPosition(new Position(1, 1)));
    }


    @Test
    void testMultipleOpeningsOnlyFirstIsUsedForEntry() {
        Maze maze = buildMaze(
            "  ##",   // Row 0: No space at col 3 → not a valid exit
            "# # ",   // Row 1: Exit at col 3
            "   #"    // Row 2
        );
    
        MazeExplorer explorer = new MazeExplorer(maze);
    
        assertEquals(new Position(0, 0), explorer.getEntry());
        assertEquals(new Position(1, 3), explorer.getExit());
    }
    
    

}
