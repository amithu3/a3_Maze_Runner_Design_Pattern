package ca.mcmaster.se2aa4.mazerunner;


import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        //Command line options
        Options option = new Options();
        Option userInput = new Option("i", "input", true, "Path to the maze file");
        userInput.setRequired(true);
        option.addOption(userInput);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine;

        try{
            //Parses the command line arguments
            cmdLine = parser.parse(option, args);

            //Obtains the maze file from the -i flag
            String mazePath = cmdLine.getOptionValue("input");
            logger.info("** Starting Maze Runner");

            logger.info("**** Reading the maze from file " + args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
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

        } catch(Exception e){
            logger.error("/!\\ An error has occured /!\\");

        }

        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");

    }
}
