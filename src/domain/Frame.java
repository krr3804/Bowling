package domain;

public interface Frame {
	boolean hasTurn();
	
	void playBowling(int pinCnt);
	
	int [] getScore();
	
	int getTotalScore();
	
	int getFrameNum();
	
	String getState();
}
