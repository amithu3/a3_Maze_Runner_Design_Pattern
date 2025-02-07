package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<char[]> grid;  // Use List<char[]> to handle variable row lengths

    // Constructor to initialize the maze from a file
    public Maze(String filePath) throws IOException {
        this.grid = loadMaze(filePath);
    }

    // Constructor to initialize the maze directly from a grid
    public Maze(List<char[]> grid) {
        this.grid = grid;
    }

    // ✅ Get the number of rows in the maze
    public int getRowCount() {
        return grid.size();
    }

    // ✅ Get the number of columns in a specific row (to handle uneven rows)
    public int getColCount(int row) {
        if (row >= 0 && row < grid.size()) {
            return grid.get(row).length;
        }
        return 0; // If row index is invalid, return 0 columns
    }

    // ✅ Get a specific cell in the maze
    public char getCell(int row, int col) {
        if (row >= 0 && row < grid.size()) {
            char[] rowArray = grid.get(row);
            if (col >= 0 && col < rowArray.length) {
                return rowArray[col];
            }
        }
        return '#'; // If out of bounds, return wall by default
    }

    public int getMaxCol() {
        int maxCol = 0;
        for (char[] row : grid) {
            maxCol = Math.max(maxCol, row.length);
        }
        return maxCol;
    }
    

    

    // ✅ Loads the maze from a file and returns a List<char[]>
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

    // ✅ Prints the maze for debugging
    public void printMaze() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

}
