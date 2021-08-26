package mancala.domain;

public class Player {
    private boolean active;
    private Player opponent;
    private String name;

    public boolean endstate;
    private int finalScore;
    private boolean playerHasWon;
    private boolean gameDraw;

    public Player() {
        name = "P2";
        opponent = new Player(this);
        active = false;
        endstate = false;
        finalScore = 0;
        playerHasWon = false;

    }

    public Player(Player opponent) {
        name = "P1";
        this.opponent = opponent;
        active = true;
        endstate = false;
        finalScore = 0;
        playerHasWon = false;
    }


    public Player getOpponent() {
        return opponent;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public boolean getPlayerHasWon() {
        return playerHasWon;
    }

    public int getfinalScore() {
        return finalScore;
    }

    public void setPlayerHasWon() {
        playerHasWon = true;
    }

    public void setGameDraw() {
        gameDraw = true;
    }

    public void setActive() {
        if (active) {
            active = false;
        } else {
            active = true;
        }
    }

    public void determineWinner() {
        if (finalScore > opponent.getfinalScore()) {
            playerHasWon = true;
        } else if (finalScore < opponent.getfinalScore()) {
            opponent.setPlayerHasWon();
        } else if (finalScore == opponent.getfinalScore()) {
            gameDraw = true;
            opponent.setGameDraw();
        }
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

}
