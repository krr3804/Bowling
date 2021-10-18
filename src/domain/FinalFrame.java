package domain;

public class FinalFrame implements Frame{
	private static final int FINAL_FRAME = 3;
	private static final int SECOND_TURN = 2;
	
	private int turn;
	private Score score;
	
	public FinalFrame() {
		turn = FINAL_FRAME;
		score = new Score(turn);
	}
	@Override
	public boolean hasTurn() {
		return turn>0;
	}
	@Override
	public void playBowling(int pinCnt) {
		setScore(pinCnt);
		setTurn();
	}
	
	private void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}
	private void setTurn() {
		if(turn == SECOND_TURN && !score.hasFinalTurn()) {
			turn-=2;
		}
		turn--;
	}
}
