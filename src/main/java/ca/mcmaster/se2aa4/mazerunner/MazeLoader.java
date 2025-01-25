package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;

public class MazeLoader {

    public static char[][] loadMaze(String filePath) {
        char[][] maze = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rows = 0;
            while ((line = reader.readLine()) != null) {
                rows++;
            }

            reader.close();
            reader = new BufferedReader(new FileReader(filePath));

            String firstLine = reader.readLine();
            int columns = firstLine.length();
            maze = new char[rows][columns];

            int row = 0;
            maze[row] = firstLine.toCharArray();
            while ((line = reader.readLine()) != null) {
                row++;
                maze[row] = line.toCharArray();
            }

        } catch (IOException e) {
            System.err.println("Error reading maze file: " + e.getMessage());
        }

        return maze;
    }
}
