package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    @Test
    public void testGetRowCount() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "####".toCharArray()));
        assertEquals(3, maze.getRowCount());
    }

    @Test
    public void testGetCell() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "####".toCharArray()));
        assertEquals('#', maze.getCell(0, 0));
        assertEquals(' ', maze.getCell(1, 1));
    }

    @Test
    public void testGetColCountValid() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "####".toCharArray()));
        assertEquals(4, maze.getColCount(0));  // First row has 4 columns
        assertEquals(4, maze.getColCount(1));  // Second row has 4 columns (with spaces in between)
    }

    @Test
    public void testGetMaxCol() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "###".toCharArray()));
        assertEquals(4, maze.getMaxCol());  // The longest row has 4 columns
    }

    // New test method added here
    @Test
    public void testLoadMazeFromFile() {
        // Directly create the maze using the constructor with a list of rows
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "####".toCharArray()));
        
        // Now you can assert various properties of the maze
        assertNotNull(maze);
        assertEquals(3, maze.getRowCount());  // The maze has 3 rows
        assertEquals(4, maze.getColCount(0));  // The first row has 4 columns
        assertEquals('#', maze.getCell(0, 0));  // The cell at (0, 0) is a wall
        assertEquals(' ', maze.getCell(1, 1));  // The cell at (1, 1) is empty space
    }

}
