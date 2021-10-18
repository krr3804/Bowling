package domain;

public class Score {
	private static final int FINAL_FRAME = 3;
	
	private static final int NORMAL_FRAME_FIRST_TURN = 2;
	
	private static final int FINAL_FRAME_FIRST_TURN = 3;
	private static final int FINAL_FRAME_SECOND_TURN = 2;
	
	private int firstShot;
	private int secondShot;
	private int finalShot;
	
	public Score (int frameState) {
		firstShot = 0;
		secondShot = 0;
		finalShot = frameState == FINAL_FRAME? 0 : -1;
	}
	
	public void setScore(int pinCnt, int turn) {
		if(finalShot != -1) {
			finalFrameSetScore(pinCnt, turn);
			return;
		}
		normalFrameSetScore(pinCnt, turn);
	}
	
	public int getTotalScore() {
		return firstShot + secondShot + finalShot;
	}
	
	public boolean hasFinalTurn() {
		return firstShot + secondShot >= 10;
	}
	
	private void finalFrameSetScore(int pinCnt, int turn) {
		switch(turn) {
			case FINAL_FRAME_FIRST_TURN:
				firstShot = pinCnt;
				break;
			case FINAL_FRAME_SECOND_TURN:
				secondShot = pinCnt;
				break;
			default:
				finalShot = pinCnt;
				break;
		}
	}
	private void normalFrameSetScore(int pinCnt, int turn) {
		switch(turn) {
			case NORMAL_FRAME_FIRST_TURN:
				firstShot = pinCnt;
				break;
			default:
				secondShot = pinCnt;
				break;
		}
	}
}
