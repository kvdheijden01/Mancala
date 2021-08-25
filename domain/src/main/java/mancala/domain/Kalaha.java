package mancala.domain;

public class Kalaha {
    protected int stones;
    private Kalaha neighbour;
    private int glorplof;
    private Player owner;
    private Kalaha opposite;


    public Kalaha() {
        this.stones = 0;
        this.owner = new Player();
        this.neighbour = new Pit(1, this, owner);
        this.glorplof = 1;

    }

    public Kalaha(int i, Kalaha j, Player owner) {
        i++;
        this.stones = 0;
        this.glorplof = i;
        if (i < 14 && i == 7) {
            this.neighbour = new Kalaha(i, j, owner);
        } else if (i < 14) {
            this.neighbour = new Pit(i, j, owner);
        } else {
            this.neighbour = j;
        }
        if (i <= 8) {
            this.owner = owner.getOpponent();
        } else {
            this.owner = owner;
        }
        
    }

    public int getStones() {
        return stones;
    }

    public Kalaha getNeighbour() {
        return neighbour;
    }

    public int getGlorplof() {
        return glorplof;
    }

    public Player getOwner() {
        return owner;
    }

    public Kalaha getOpposite() {
        return opposite;
    }

    public void setOpposite(Kalaha opposite) {
        this.opposite = opposite;
    }

    public void passStones(int n) {
        if (n > 0) {
            if (owner.getActive()) {
                passStonesToNeighbour(n);
            } else {
                skipPassingStonesOneField(n);
            }
        } else if (n == 0) {
            checkResultsOfMove();
            
        }
    }

    public void passStonesToNeighbour(int n) {
        int stonesToPass = n;
        stones = stones - n;
        getNeighbour().stones = getNeighbour().stones + stonesToPass;
        n--;
        getNeighbour().passStones(n);
    }

    private void skipPassingStonesOneField(int n) {
        stones = stones - (n+1);
        getNeighbour().stones = getNeighbour().stones + (n+1);
        getNeighbour().passStones(n);
    }

    public void checkResultsOfMove() {
        checkEndstate();

    }

    public void checkEndstate() {
        checkPlayerHalf(owner);
        checkPlayerHalf(owner.getOpponent());
    }

    public void checkPlayerHalf(Player player) {
        int count = 0;
        for (int i = 0; i < 14; i++) {
            if (this.goToNeighbour(i).getOwner().equals(player)) {
                count = this.goToNeighbour(i).checkIfEmpty(count);
            }
        }
        if (count == 6) {
            owner.setEndstate();
        }
    }

    public int checkIfEmpty(int count) {
        return count;
    }

    public void depositStolenStones(int stonesToPass) {
        if (owner.getActive()) {
            stones = stones + stonesToPass;
        }
    }

    // THese methods are used for testing
    public Kalaha goToNeighbour(int num) {
        Kalaha currentField = this;
        for (int i = 0; i < num; i++) {
            currentField = currentField.getNeighbour();
        }
        return currentField;
    }
}
