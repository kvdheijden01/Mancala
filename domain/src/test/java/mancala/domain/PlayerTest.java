package mancala.domain;

// Your test class should be in the same 
// package as the class you're testing.
// Usually the test directory mirrors the
// main directory 1:1. So for each class in src/main,
// there is a class in src/test.

// Import our test dependencies. We import the Test-attribute
// and a set of assertions.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void eachFieldHasTheCorrectPlayersAssigned() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        assertEquals("P1",field.goToNeighbour(1).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(2).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(3).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(4).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(5).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(6).getOwner().getName());
        assertEquals("P1",field.goToNeighbour(7).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(8).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(9).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(10).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(11).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(12).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(13).getOwner().getName());
        assertEquals("P2",field.goToNeighbour(14).getOwner().getName());

    }

    @Test
    public void theActivePlayerisSetToP1() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        assertEquals("P1",field.goToNeighbour(1).getOwner().getActivePlayer().getName());
    }
    
}
