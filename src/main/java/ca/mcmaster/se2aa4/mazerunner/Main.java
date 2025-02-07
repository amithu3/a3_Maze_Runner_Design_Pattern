package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;

/**
 * Main class for executing the Maze Runner program.
 * This class processes command-line arguments, loads a maze file, and either
 * validates a given path or computes a solution using a maze-solving algorithm.
 *
 * Author: Midhousha Anura
 * Course: SFWRENG 2AA4
 * Assignment: A1 - Maze Runner
 * Date: February 1, 2025
 */
public class Main {
    
    // Logger for logging errors, warnings, and debug information
    private static final Logger logger = LogManager.getLogger();

    /**
     * Main entry point for the program.
     * Parses command-line arguments, loads the maze file, and performs either path validation
     * or maze-solving, depending on the provided options.
     *
     * @param args Command-line arguments.
     *             - "-i <file_path>": Specifies the path to the maze file (mandatory).
     *             - "-p <path>": Specifies a path to validate within the maze (optional).
     *
     * If no "-p" option is provided, the program attempts to solve the maze using the
     * RightHandSolver strategy.
     */
    public static void main(String[] args) {
        // Disable logging messages
        Configurator.setRootLevel(Level.OFF);

        // Define command-line options
        Options options = new Options();
        options.addOption(new Option("i", "input", true, "Path to the maze file"));
        options.addOption(new Option("p", "path", true, "Path to validate"));

        CommandLineParser parser = new DefaultParser();

        try {
            // Parse command-line arguments
            CommandLine cmd = parser.parse(options, args);
            
            // Ensure the maze file is provided
            if (!cmd.hasOption("i")) {
                logger.error("Maze file must be specified with -i flag.");
                System.exit(1);
            }

            // Load the maze from the provided file path
            String mazePath = cmd.getOptionValue("i");
            Maze maze = new Maze(mazePath);
            
            // If the user provides a path to validate, validate it
            if (cmd.hasOption("p")) {
                String path = cmd.getOptionValue("p");
                PathValidator validator = new PathValidator(maze);
                boolean isValid = validator.validatePath(path);
                System.out.println(isValid ? "Path is valid!" : "Path is invalid!");
            } else {
                // If no validation path is provided, solve the maze
                logger.info("**** Calling solve() on maze");
                MazeSolver solver = new RightHandSolver();
                String solution = solver.solve(maze);

                // Check if the solver returned a valid path
                if (solution.isEmpty()) {
                    logger.error("**** Solver returned an empty path!");
                } else {
                    logger.info("**** Computed Path: " + solution);
                    if (solution == null || solution.isEmpty()) {
                        logger.error("**** Solver returned an empty path!");
                        System.out.println("ERROR: No path computed.");
                    } 
                }
            }
        } catch (ParseException e) {
            logger.error("Error parsing command-line arguments", e);
        } catch (IOException e) {
            // Handle cases where the maze file cannot be loaded
            logger.error("Error loading the maze file", e);
            System.out.println("ERROR: Could not load maze file. Please check the file name and path.");
            System.exit(1);
        }
    }
}
