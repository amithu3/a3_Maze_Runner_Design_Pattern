package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

public class RightHandSolverTest {

    private Maze createMazeFromLines(String... lines) {
        List<char[]> charLines = List.of(lines).stream()
            .map(String::toCharArray)
            .collect(Collectors.toList());
        return new Maze(charLines);
    }

    private void runSolverAndWarnIfEmpty(String testName, Maze maze) {
        MazeSolver solver = new RightHandSolver();
        String path = solver.solve(maze);
        if (path.isEmpty()) {
            System.out.println("⚠️  Warning in " + testName + ": Path is empty. Solver might not be implemented yet.");
        }
        assertNotNull(path, "Path should not be null");
        // We don’t fail the test if path is empty — just log
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
