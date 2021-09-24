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
        assertEquals(true,field.goToNeighbour(1).getOwner().isActive());
    }

    @Test
    public void anEmptyBoardP1InitiatesEndstate() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(0);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(true, field.getNeighbour().getOwner().endstate);
    }

    @Test
    public void aBoardWithStonesDoesNotInitiateEndstate() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(1);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(false, field.goToNeighbour(6).getOwner().endstate);
        assertEquals(false, field.getOwner().endstate);
    }
    
    @Test
    public void aMoveIntoKalahaInitiatesEndstate() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(0);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).setStones(1);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(true, field.getNeighbour().getOwner().endstate);
    }
    

    @Test
    public void P2HasAFinalScore() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(0);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(27, field.getOwner().getfinalScore());
        assertEquals(1, field.getOwner().getOpponent().getfinalScore());
    }


    @Test
    public void P2WinsIfTheyHaveMoreStonesOnTheirBoard() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(0);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(true, field.getOwner().getPlayerHasWon());
    }

    @Test
    public void equalScoreResutlsInADraw() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(1)).setStones(0);
        ((Pit) field.goToNeighbour(2)).setStones(0);
        ((Pit) field.goToNeighbour(3)).setStones(0);
        ((Pit) field.goToNeighbour(4)).setStones(0);
        ((Pit) field.goToNeighbour(5)).setStones(0);
        ((Pit) field.goToNeighbour(6)).setStones(1);
        ((Pit) field.goToNeighbour(8)).setStones(0);
        ((Pit) field.goToNeighbour(9)).setStones(0);
        ((Pit) field.goToNeighbour(12)).setStones(0);
        ((Pit) field.goToNeighbour(10)).setStones(0);
        ((Pit) field.goToNeighbour(11)).setStones(0);
        ((Pit) field.goToNeighbour(13)).setStones(1);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(true, field.getNeighbour().getOwner().getGameDraw());
        assertEquals(false, field.getOwner().getPlayerHasWon());
    }
}
