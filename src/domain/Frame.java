package domain;

public class Frame {
	private static final int TOTAL_FRAME = 9;
	private static final int NORMAL_FRAME = 2;
	private static final int FINAL_FRAME = 3;
	private static final int TOTAL_PINS = 10;

	private int turn;
	private int firstShot;

	public Frame(int frameNumber) {
		if(frameNumber == TOTAL_FRAME) {
			turn = FINAL_FRAME;
			return;
		}
		turn = NORMAL_FRAME;
	}
	public void calculateScore(int pinCnt) {
		if(pinCnt == TOTAL_PINS) {
			this.turn-=2;
		}
		this.turn--;
	}
	
	public boolean hasTurn() {
		return turn>0;
	}

}
