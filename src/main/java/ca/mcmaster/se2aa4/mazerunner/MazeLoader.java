package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Position;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MazeLoader {

    public static char[][] loadMaze(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.stream().map(String::toCharArray).toArray(char[][]::new);
    }
}
