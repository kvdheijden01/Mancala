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
        if (getOwner().isActive()) {
            int n = stones;
            stones = 0;
            getNeighbour().passStones(n);
        }
    }

    @Override
    public void checkResultsOfMove() {
    if ((super.stones == 1) && getOwner().isActive()) {
        stealStones();
    }
    switchActivePlayer();
    checkEndstate();
    }

    private void switchActivePlayer() {
        this.getOwner().setActive();
        this.getOwner().getOpponent().setActive();
    }

    protected void stealStones() {
        int stonesToPass = stones;
        this.stones = 0;
        getOpposite().stones = getOpposite().stones + stonesToPass;
        stonesToPass = getOpposite().stones;
        getOpposite().stones = 0;
        for (int i = 1; i <= 14; i++) {
            this.goToNeighbour(i).depositStolenStones(stonesToPass);
            
        }

    }

    @Override
    protected void passStones(int n) {
        if (n > 1) {
            passStonesToNeighbour(n);
        } else if (n == 1) {
            stones++;
            checkResultsOfMove();
            
        }
    }

    @Override
    protected boolean hasGameEnded() {
        if (stones == 0) {
            return getNeighbour().hasGameEnded();
        } else {
            return false;
        }
    }

    @Override
    protected void depositStolenStones(int stonesToPass) {
        
    }

    @Override
    protected int countScore() {
        return stones + getNeighbour().countScore();
    }

    @Override
    public Kalaha goToFirstPit(Player player) {
        return getNeighbour().goToFirstPit(player);
    }

    // These methods are used for testing.
    public void setStones(int stones) {
        this.stones = stones;
    }

    
}
