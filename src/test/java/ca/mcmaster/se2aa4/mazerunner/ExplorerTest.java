package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {
    
    @Test
    public void testTurnLeft() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.UP);
        explorer.turnLeft();
        assertEquals(Direction.LEFT, explorer.getDirection());
    }

    @Test
    public void testTurnRight() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.UP);
        explorer.turnRight();
        assertEquals(Direction.RIGHT, explorer.getDirection());
    }



    @Test
    public void testGetPosition() {
        Explorer explorer = new Explorer(new Position(2, 3), Direction.RIGHT);
        Position expectedPosition = new Position(2, 3);
        assertEquals(expectedPosition, explorer.getPosition());
    }

    @Test
    public void testTurnRightFromDown() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.DOWN);
        explorer.turnRight();
        assertEquals(Direction.LEFT, explorer.getDirection());
    }

    @Test
    public void testTurnLeftFromRight() {
        Explorer explorer = new Explorer(new Position(0, 0), Direction.RIGHT);
        explorer.turnLeft();
        assertEquals(Direction.UP, explorer.getDirection());
    }
}
