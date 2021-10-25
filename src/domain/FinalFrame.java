package domain;

public class FinalFrame implements Frame{
	private static final int FINAL_FRAME = 3;
	private static final int SECOND_TURN = 2;
	
	private int turn;
	private Score score;
	private int frameNum;
	
	public FinalFrame(int frameNum) {
		this.frameNum = frameNum;
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
	private void setTurn() {
		if(turn == SECOND_TURN && !score.hasFinalTurn()) {
			turn-=2;
		}
		turn--;
	}
}
