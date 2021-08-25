package mancala.domain;

public class Player {
    private boolean active;
    private Player opponent;
    private String name;

    public boolean endstate;

    public Player() {
        this.name = "P2";
        this.opponent = new Player(this);
        active = false;
        endstate = false;

    }

    public Player(Player opponent) {
        this.name = "P1";
        this.opponent = opponent;
        this.active = true;
    }


    public Player getOpponent() {
        return opponent;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive() {
        if (active) {
            active = false;
        } else {
            active = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setEndstate() {
        endstate = true;

    }

}
