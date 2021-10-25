package domain;

import java.util.Arrays;

public class Score {
	private static final int FIRST_SHOT = 0;
	private static final int SECOND_SHOT = 1;
	private static final int FINAL_SHOT = 2;
	
	private static final int FINAL_FRAME = 3;
	private static final int NORMAL_FRAME = 2;
	
	private static final int NORMAL_FRAME_FIRST_TURN = 2;
	
	private static final int FINAL_FRAME_FIRST_TURN = 3;
	private static final int FINAL_FRAME_SECOND_TURN = 2;
	
	private int [] shotScores;
	private String state;
	
	public Score (int frameState) {
		if(frameState == FINAL_FRAME) {
			shotScores = new int [FINAL_FRAME];
		}
		shotScores = new int [NORMAL_FRAME];
		state = "NORMAL";
	}
	
	public String getState() {
		return state;
	}
	
	public int[] getShotScores() {
		return shotScores;
	}
	
	public void setScore(int pinCnt, int turn) {
		if(shotScores.length == FINAL_FRAME) {
			finalFrameSetScore(pinCnt, turn);
			return;
		}
		normalFrameSetScore(pinCnt, turn);
	}
	
	public int getTotalScore() {
		return Arrays.stream(shotScores).sum();
	}
	
	public boolean hasFinalTurn() {
		return shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] >= 10;
	}
	
	private void finalFrameSetScore(int pinCnt, int turn) {
		switch(turn) {
			case FINAL_FRAME_FIRST_TURN:
				shotScores[FIRST_SHOT] = pinCnt;
				break;
			case FINAL_FRAME_SECOND_TURN:
				shotScores[SECOND_SHOT] = pinCnt;
				break;
			default:
				shotScores[FINAL_FRAME] = pinCnt;
				break;
		}
	}
	private void normalFrameSetScore(int pinCnt, int turn) {
		switch(turn) {
			case NORMAL_FRAME_FIRST_TURN:
				shotScores[FIRST_SHOT] = pinCnt;
				break;
			default:
				shotScores[SECOND_SHOT] = pinCnt;
				break;
		}
	}
	public void setState () {
		if(shotScores[FIRST_SHOT] == 10) {
			state = "STRIKE";
			return;
		}
		if(shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] == 10) {
			state = "SPAIRE";
			return;
		}
	}
}
