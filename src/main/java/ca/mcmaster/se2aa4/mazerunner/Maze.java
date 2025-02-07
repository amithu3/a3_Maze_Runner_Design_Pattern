/**
 * @file Maze.java
 * @author Midhousha Anura
 * @course SFWRENG 2AA4
 * @assignment A1 - Maze Runner
 * @date Feb 1, 2025
 *
 * This class represents a maze, which can be loaded from a file or initialized from a given grid.
 * It provides methods to access maze dimensions, retrieve specific cells, and handle irregular row lengths.
 */

 package ca.mcmaster.se2aa4.mazerunner;

 import java.io.*;
 import java.util.ArrayList;
 import java.util.List;
 
 public class Maze {
     private final List<char[]> grid;  // Use List<char[]> to handle variable row lengths
 
     /**
      * Constructor that initializes the maze from a given file.
      *
      * @param filePath The path to the maze file.
      * @throws IOException If the file cannot be read or is empty.
      */
     public Maze(String filePath) throws IOException {
         this.grid = loadMaze(filePath);
     }
 
     /**
      * Constructor that initializes the maze directly from a provided grid.
      *
      * @param grid A list of character arrays representing the maze layout.
      */
     public Maze(List<char[]> grid) {
         this.grid = grid;
     }
 
     /**
      * Retrieves the number of rows in the maze.
      *
      * @return The total number of rows in the maze.
      */
     public int getRowCount() {
         return grid.size();
     }
 
     /**
      * Retrieves the number of columns in a specific row, accounting for uneven row lengths.
      *
      * @param row The row index.
      * @return The number of columns in the given row, or 0 if the row index is invalid.
      */
     public int getColCount(int row) {
         if (row >= 0 && row < grid.size()) {
             return grid.get(row).length;
         }
         return 0; // If row index is invalid, return 0 columns
     }
 
     /**
      * Retrieves the character at a specific position in the maze.
      *
      * @param row The row index.
      * @param col The column index.
      * @return The character at the specified position, or '#' if out of bounds.
      */
     public char getCell(int row, int col) {
         if (row >= 0 && row < grid.size()) {
             char[] rowArray = grid.get(row);
             if (col >= 0 && col < rowArray.length) {
                 return rowArray[col];
             }
         }
         return '#'; // If out of bounds, return wall by default
     }
 
     /**
      * Retrieves the maximum number of columns in any row of the maze.
      *
      * @return The maximum column count found in the maze.
      */
     public int getMaxCol() {
         int maxCol = 0;
         for (char[] row : grid) {
             maxCol = Math.max(maxCol, row.length);
         }
         return maxCol;
     }
 
     /**
      * Loads a maze from a file and returns a list of character arrays representing the rows.
      *
      * @param filePath The path to the maze file.
      * @return A list of character arrays representing the maze.
      * @throws IOException If the file cannot be read or is empty.
      */
     private static List<char[]> loadMaze(String filePath) throws IOException {
         List<char[]> lines = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 lines.add(line.toCharArray());
             }
         }
 
         if (lines.isEmpty()) {
             throw new IOException("Error: Maze file is empty.");
         }
 
         return lines;
     }
 }
 