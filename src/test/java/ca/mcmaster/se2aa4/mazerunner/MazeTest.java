package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Maze class.
 * Verifies correct loading, cell access, and row/column properties.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
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
        assertEquals(4, maze.getColCount(0));
        assertEquals(4, maze.getColCount(1));
    }

    @Test
    public void testGetMaxCol() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "###".toCharArray()));
        assertEquals(4, maze.getMaxCol());
    }

    /**
     * Tests maze loading from a provided grid.
     */
    @Test
    public void testLoadMazeFromFile() {
        Maze maze = new Maze(List.of("####".toCharArray(), "#  #".toCharArray(), "####".toCharArray()));

        assertNotNull(maze);
        assertEquals(3, maze.getRowCount());
        assertEquals(4, maze.getColCount(0));
        assertEquals('#', maze.getCell(0, 0));
        assertEquals(' ', maze.getCell(1, 1));
    }
}
