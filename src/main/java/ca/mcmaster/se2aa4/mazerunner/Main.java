package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import ca.mcmaster.se2aa4.mazerunner.MazeSolvingStrategy;

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
                MazeSolvingStrategy solver = new RightHandSolver(); // Strategy pattern in action
                String solution = solver.solve(maze);

                if (solution.isEmpty()) {
                    logger.error("**** Solver returned an empty path!");
                    System.out.println("ERROR: No path computed.");
                }
            }
        } catch (ParseException e) {
            logger.error("Error parsing command-line arguments", e);
        } catch (IOException e) {
            logger.error("Error loading the maze file", e);
            System.out.println("ERROR: Could not load maze file. Please check the file name and path.");
            System.exit(1);
        }
    }
}
