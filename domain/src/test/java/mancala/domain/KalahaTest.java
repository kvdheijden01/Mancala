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
public class KalahaTest {

    @Test
    public void aKalahaStartsWithZeroStones() {
        Kalaha veld = new Kalaha();
        assertEquals(0,veld.getStones());
        assertEquals(0,veld.goToNeighbour(7).getStones());
        assertEquals(0,veld.goToNeighbour(14).getStones());

    }

    @Test
    public void aFieldHasANeighbour() {
        Kalaha field = new Kalaha();
        assertEquals(2,field.getNeighbour().getGlorplof());
    }
    
    @Test
    public void theBoardHas14Fields() {
        Kalaha field = new Kalaha();
        assertEquals(1,field.goToNeighbour(14).getGlorplof());
    }

    @Test
    public void aMoveSkipsTheOpponetsKalaha() {
        Kalaha field = new Kalaha();
        ((Pit) field.goToNeighbour(6)).setStones(10);
        ((Pit) field.goToNeighbour(6)).doMove();
        assertEquals(1,field.goToNeighbour(7).getStones());
        assertEquals(5,field.goToNeighbour(13).getStones());
        assertEquals(0,field.goToNeighbour(14).getStones());
        assertEquals(5,field.goToNeighbour(15).getStones());
        assertEquals(5,field.goToNeighbour(16).getStones());
        
    }

    @Test
    public void endingInYourKalahaDoesNotSwitchActivePlayer() {
        Kalaha field = new Kalaha();
        assertEquals(true,field.getNeighbour().getOwner().getActive());
        ((Pit) field.goToNeighbour(3)).doMove();
        assertEquals(true,field.getNeighbour().getOwner().getActive());
    }

}
