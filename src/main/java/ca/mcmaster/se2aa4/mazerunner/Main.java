package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.OFF);

        Options options = new Options();
        options.addOption(new Option("i", "input", true, "Path to the maze file"));
        options.addOption(new Option("p", "path", true, "Path to validate"));

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            
            if (!cmd.hasOption("i")) {
                logger.error("Maze file must be specified with -i flag.");
                System.exit(1);
            }

            String mazePath = cmd.getOptionValue("i");
            Maze maze = new Maze(mazePath);
            
            if (cmd.hasOption("p")) {
                String path = cmd.getOptionValue("p");
                PathValidator validator = new PathValidator(maze);
                boolean isValid = validator.validatePath(path);
                System.out.println(isValid ? "Path is valid!" : "Path is invalid!");
            } else {
                logger.info("**** Calling solve() on maze");
                MazeSolver solver = new RightHandSolver();
                String solution = solver.solve(maze);

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
            logger.error("Error loading the maze file", e);
        }
    }
}