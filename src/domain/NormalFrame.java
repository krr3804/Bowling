package domain;

public class NormalFrame implements Frame {
	private static final int NORMAL_FRAME = 2;
	private static final int TOTAL_PINS = 10;

	private int turn;
	private Score score;
	private int frameNum;

	public NormalFrame(int frameNum) {
		this.frameNum = frameNum;
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
	
	@Override
	public int[] getScore() {
		return score.getShotScores();
	}
	
	@Override
	public int getTotalScore() {
		return score.getTotalScore();
	}
	
	@Override
	public int getFrameNum() {
		return frameNum;
	}
	
	@Override
	public String getState() {
		return score.getState();
	}
	
	private void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}
	
	private void setTurn(int pinCnt) {
		score.setState();
		if (pinCnt == TOTAL_PINS) {
			turn-=2;
			return;
		}
		turn--;
	}	
}
