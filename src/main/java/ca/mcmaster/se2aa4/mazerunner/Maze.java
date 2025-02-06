package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final char[][] grid;  // Mark grid as final since it shouldn't be modified after initialization

    // Constructor to initialize the maze from a file
    public Maze(String filePath) throws IOException {
        this.grid = loadMaze(filePath);
    }

    // Constructor to initialize the maze directly from a grid
    public Maze(char[][] grid) {
        this.grid = grid;
    }

    // Getter method for grid access
    public char[][] getGrid() {
        return grid;
    }

    // Loads the maze from a file and returns a 2D char array
    private static char[][] loadMaze(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    if (!lines.isEmpty()) {  // Use the previous row length to maintain width consistency
                        int width = lines.get(0).length();
                        line = " ".repeat(width);
                    } else {
                        throw new IOException("Error: First row of maze cannot be empty.");
                    }
                }
                lines.add(line);
            }
        }
    
        if (lines.isEmpty()) {
            throw new IOException("Error: Maze file is empty.");
        }
    
        int width = lines.get(0).length();
        System.out.println("Expected width: " + width);
    
        for (String line : lines) {
            System.out.println("Line: [" + line + "] Length: " + line.length());
            if (line.length() != width) {
                throw new IOException("Error: Maze file contains inconsistent row lengths.");
            }
        }
    
        return lines.stream().map(String::toCharArray).toArray(char[][]::new);
    }
    

    // Prints the maze for debugging
    public void printMaze() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}
