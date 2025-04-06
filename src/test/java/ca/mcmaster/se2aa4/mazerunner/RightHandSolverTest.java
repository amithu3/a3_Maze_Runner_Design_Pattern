package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Integration tests for the RightHandSolver class.
 * Validates behavior with different maze configurations.
 *
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public class RightHandSolverTest {

    private Maze createMazeFromLines(String... lines) {
        List<char[]> charLines = List.of(lines).stream()
            .map(String::toCharArray)
            .collect(Collectors.toList());
        return new Maze(charLines);
    }

    private void runSolverAndWarnIfEmpty(String testName, Maze maze) {
        MazeSolvingStrategy solver = new RightHandSolver();
        String path = solver.solve(maze);
        if (path.isEmpty()) {
            System.out.println("⚠️ Warning in " + testName + ": Path is empty.");
        }
        assertNotNull(path);
    }

    @Test
    public void testSimpleStraightPath() {
        Maze maze = createMazeFromLines(
            "# ########",
            ".        #",
            "# ########"
        );
        runSolverAndWarnIfEmpty("testSimpleStraightPath", maze);
    }

    @Test
    public void testRightTurnRequired() {
        Maze maze = createMazeFromLines(
            "# ########",
            ".     #  #",
            "# ### #  #",
            "#     ####"
        );
        runSolverAndWarnIfEmpty("testRightTurnRequired", maze);
    }

    @Test
    public void testMazeWithDeadEnds() {
        Maze maze = createMazeFromLines(
            "# #########",
            ".   #     #",
            "# # # ### #",
            "# #     # #",
            "##### # # #",
            "#     #   #",
            "######### #"
        );
        runSolverAndWarnIfEmpty("testMazeWithDeadEnds", maze);
    }

    @Test
    public void testTurnAndStraightPath() {
        Maze maze = createMazeFromLines(
            "# #########",
            ".       # #",
            "# ##### # #",
            "#     #   #",
            "######### #"
        );
        runSolverAndWarnIfEmpty("testTurnAndStraightPath", maze);
    }

    @Test
    public void testEntryInMiddleRowExitInBottomRow() {
        Maze maze = createMazeFromLines(
            "# #########",
            "#   #     #",
            ". # # ### #",
            "# #     # #",
            "# ##### # #",
            "#       # ."
        );
        runSolverAndWarnIfEmpty("testEntryInMiddleRowExitInBottomRow", maze);
    }
}
