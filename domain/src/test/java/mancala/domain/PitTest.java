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
public class PitTest {
    
    
    @Test
    public void aPitStartsWithFourStones() {
        Kalaha field = new Kalaha();
        assertEquals(4,field.getNeighbour().getStones());
    }

    @Test
    public void aPitIsEmptyafterPassingStones() {
        Kalaha field = new Kalaha();
        ((Pit) field.goToNeighbour(1)).doMove();
        assertEquals(0,field.getNeighbour().getStones());

    }

    @Test
    public void theBoardHas12PitsAnd2Kalaha() {
        Kalaha field = new Kalaha();
        assertEquals(0,field.getStones());
        assertEquals(4,field.goToNeighbour(4).getStones());
        assertEquals(0,field.goToNeighbour(7).getStones());
        assertEquals(4,field.goToNeighbour(10).getStones());
    }

    @Test
    public void aPitpassesStonesToTheirNeighbour() {
        Kalaha field = new Kalaha();
        ((Pit) field.goToNeighbour(1)).doMove();
        assertEquals(5,field.goToNeighbour(2).getStones());
    }

    @Test
    public void aMovePassesStonesAllongTheBoard() {
        Kalaha field = new Kalaha();
        ((Pit) field.goToNeighbour(1)).doMove();
        assertEquals(5,field.goToNeighbour(2).getStones());
        assertEquals(5,field.goToNeighbour(3).getStones());
        assertEquals(5,field.goToNeighbour(4).getStones());
        assertEquals(5,field.goToNeighbour(5).getStones());
        assertEquals(4,field.goToNeighbour(6).getStones());
    }

    @Test
    public void endingInAPitSwitchesActivePlayer() {
        Kalaha field = new Kalaha();
        assertEquals(true,field.getNeighbour().getOwner().getActive());
        ((Pit) field.goToNeighbour(1)).doMove();
        assertEquals(false,field.getNeighbour().getOwner().getActive());
    }

    @Test
    public void endingInAnEmptyPitMovesStonesToTheOpositePit() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(6)).setStones(0);
        ((Pit) field.goToNeighbour(2)).doMove();
        assertEquals(0, field.goToNeighbour(6).getStones());
    }

    @Test
    public void aPitSetstheOppositePit() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        assertEquals(field.goToNeighbour(13), field.goToNeighbour(1).getOpposite());
        assertEquals(field.goToNeighbour(12), field.goToNeighbour(2).getOpposite());
        assertEquals(field.goToNeighbour(11), field.goToNeighbour(3).getOpposite());
        assertEquals(field.goToNeighbour(10), field.goToNeighbour(4).getOpposite());
        assertEquals(field.goToNeighbour(9), field.goToNeighbour(5).getOpposite());
        assertEquals(field.goToNeighbour(8), field.goToNeighbour(6).getOpposite());

    }

    @Test
    public void aPitMovesItAndItsOppositesStonesIntoTheKalahaOfTheStealingPlayer() {
        Kalaha field = new Kalaha();
        ((Pit) field.getNeighbour()).setOppositeField();
        ((Pit) field.goToNeighbour(6)).setStones(0);
        ((Pit) field.goToNeighbour(2)).doMove();
        assertEquals(0, field.goToNeighbour(6).getOpposite().getStones());
        assertEquals(5, field.goToNeighbour(5).getStones());
        assertEquals(5, field.goToNeighbour(7).getStones());
        assertEquals(0, field.goToNeighbour(14).getStones());
        assertEquals(4, field.goToNeighbour(9).getStones());

    }


}
