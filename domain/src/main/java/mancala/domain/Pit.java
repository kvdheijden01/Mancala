package mancala.domain;

public class Pit extends Kalaha {
    
    public Pit() {
        this.stones = 4;
    }

    public Pit(int i, Kalaha j, Player owner) {
        super(i, j, owner);
        this.stones = 4;

    }

    public void setOppositeField() {
        for (int i = 0; i < 6; i++) {
            int count = 0;
            Kalaha currentField = this.goToNeighbour(i);
            while (currentField.getStones() != 0) {
                count++;
                currentField = currentField.getNeighbour();
            }
            this.goToNeighbour(i).setOpposite(currentField.goToNeighbour(count));
        }

    }

    public void doMove() {
        int n = stones;
        this.passStones(n);
    }

    @Override
    public void checkResultsOfMove() {
    if (stones == 1) {
        stealStones();
    }
    switchActivePlayer();
    }

    private void switchActivePlayer() {
        getOwner().setActivePlayer(getOwner().getOpponent());
    }

    private void stealStones() {
        int stonesToPass = stones;
        stones = 0;
        getOpposite().stones = getOpposite().stones + stonesToPass;
        stonesToPass = getOpposite().stones;
        getOpposite().stones = 0;
        for (int i = 1; i <= 14; i++) {
            this.goToNeighbour(i).depositStolenStones(stonesToPass);
            
        }

    }

    @Override
    public void depositStolenStones(int stonesToPass) {
        
    }



    // These methods are used for testing.
    public void setStones(int stones) {
        this.stones = stones;
    }

    
}
