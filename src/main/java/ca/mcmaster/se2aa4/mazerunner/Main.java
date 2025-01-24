package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        // Command line options
        Options option = new Options();

        // i input
        Option userInput = new Option("i", "input", true, "Path to the maze file");
        userInput.setRequired(true);
        option.addOption(userInput);

        // p path validation
        Option pathOption = new Option("p", "path", true, "Path to validate (e.g., FFFF)");
        pathOption.setRequired(false);
        option.addOption(pathOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine;

        try {
            // Parses the command line arguments
            cmdLine = parser.parse(option, args);

            // Obtains the maze file from the -i flag
            String mazePath = cmdLine.getOptionValue("input");
            logger.info("** Starting Maze Runner");

            // Loads the maze
            logger.info("**** Reading the maze from file " + mazePath);
            loadMaze(mazePath);

            // Determines whethet -p flag is received
            if (cmdLine.hasOption("path")) {
                String path = cmdLine.getOptionValue("path");
                logger.info("**** Path to validate: " + path);
            }

        } catch (ParseException e) {
            logger.error("Failed to parse command-line arguments: " + e.getMessage());
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e.getMessage(), e);
        }

        logger.info("** End of Maze Runner");
    }

    /**
     * Loads the maze from the file and prints it. This is a skeleton of loading a
     * maze
     */

    private static void loadMaze(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            logger.error("Maze file not found: " + filePath);
        } catch (IOException e) {
            logger.error("Error reading the maze file: " + filePath);
        } catch (Exception e) {
            logger.error("An unexpected error occurred while loading the maze from file: " + filePath, e);
        }

        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");

    }
}
