package domain;

public class NormalFrame implements Frame {
	private static final int NORMAL_FRAME = 2;
	private static final int TOTAL_PINS = 10;

	private int turn;
	private Score score;

	public NormalFrame(int frameNumber) {
		turn = NORMAL_FRAME;
		score = new Score(turn);
	}
	
	@Override
	public boolean hasTurn() {
		return turn>0;
	}
	
	@Override
	public void playBowling(int pinCnt) {
		setScore(pinCnt);
		setTurn(pinCnt);
	}
	
	private void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}
	
	private void setTurn(int pinCnt) {
		if (pinCnt == TOTAL_PINS) {
			turn-=2;
			return;
		}
		turn--;
	}	
}
