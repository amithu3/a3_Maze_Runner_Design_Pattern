package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;

public class MazeLoader {

    public static char[][] loadMaze(String filePath) {
        char[][] maze = null;
        int rows = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
            }
        } catch (IOException e) {
            System.err.println("Error reading maze file (row count): " + e.getMessage());
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine();
            if (firstLine == null) {
                System.err.println("Error: Maze file is empty.");
                return null;
            }

            int columns = firstLine.length();
            maze = new char[rows][columns];

            int row = 0;
            maze[row] = firstLine.toCharArray();
            String line;
            while ((line = reader.readLine()) != null) {
                row++;
                maze[row] = line.toCharArray();
            }
        } catch (IOException e) {
            System.err.println("Error reading maze file (data load): " + e.getMessage());
        }

        return maze;
    }
}
