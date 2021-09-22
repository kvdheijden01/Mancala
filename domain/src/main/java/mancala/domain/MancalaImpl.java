package mancala.domain;

public class MancalaImpl implements Mancala {
    Kalaha board;

    public MancalaImpl() {
        // Initialize the game here.
        this.board = new Kalaha();
        ((Pit) board.getNeighbour()).setOppositeField();
        
    }

    @Override
    public boolean isPlayersTurn(int player) {
        if (player == 1) {
            if (board.getNeighbour().getOwner().isActive()) {
                return true;
            }
            return false;
        } else if (player == 2) {
            if (board.getOwner().isActive()) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
	public void playPit(int index) throws MancalaException {
        // Implement playing a pit.
        ((Pit) board.goToNeighbour(index + 1)).doMove();
    }
	
	@Override
	public int getStonesForPit(int index) {
        // Make a sane implementation.
    return board.goToNeighbour(index + 1).getStones();

    }

	@Override
	public boolean isEndOfGame() {
        if (board.getOwner().endstate) {
            return true;
        }
        return false;
    }

	@Override
	public int getWinner() {
        if (board.getNeighbour().getOwner().getPlayerHasWon()) {
            return Mancala.PLAYER_ONE;
        } else if (board.getOwner().getPlayerHasWon()) {
            return Mancala.PLAYER_TWO;
        } else if (board.getOwner().getGameDraw()) {
            return Mancala.BOTH_PLAYERS;
        } else {
            return Mancala.NO_PLAYERS;
        }
            
    }
}