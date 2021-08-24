package mancala.domain;

public class Player {
    private static Player activePlayer;
    private Player opponent;
    private String name;

    public Player() {
        this.name = "P2";
        this.opponent = new Player(this);
        activePlayer = this.opponent;

    }

    public Player(Player opponent) {
        this.name = "P1";
        this.opponent = opponent;
    }


    public Player getOpponent() {
        return opponent;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public String getName() {
        return name;
    }

}
