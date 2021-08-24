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

    protected void passStones(int n) {
        if (n > 0 && this instanceof Pit) {
            int stonesToPass = n;
            stones = stones - n;
            getNeighbour().stones = getNeighbour().stones + stonesToPass;
            n--;
            getNeighbour().passStones(n);
        } else if (n > 0 && this instanceof Kalaha) {
            if (owner.getActivePlayer().equals(owner)) {
                int stonesToPass = n;
                stones = stones - n;
                getNeighbour().stones = getNeighbour().stones + stonesToPass;
                n--;
                getNeighbour().passStones(n);
            } else {
                stones = stones - (n+1);
                getNeighbour().stones = getNeighbour().stones + (n+1);
                getNeighbour().passStones(n);
            }
        } else if (n == 0) {
            checkResultsOfMove();
        }
    }

    public void checkResultsOfMove() {

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
