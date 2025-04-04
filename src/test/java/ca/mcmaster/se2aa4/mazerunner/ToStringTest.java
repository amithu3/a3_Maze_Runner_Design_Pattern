package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToStringTest {
    @Test
    public void testToString() {
        Position position = new Position(3, 4);
        assertEquals("Position(3, 4)", position.toString());
    }
    
    @Test
    public void testToStringNegativeValues() {
        Position position = new Position(-1, -2);
        assertEquals("Position(-1, -2)", position.toString());
    }
}
