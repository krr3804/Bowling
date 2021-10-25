package domain;

public class Pins {
	
	private static final int MAX_BOWLING_PINS = 10;
	
	private int bowlingPins;
	
	public Pins() {
		this.bowlingPins = MAX_BOWLING_PINS;
	}
	
	public void resetPin() {
		this.bowlingPins = MAX_BOWLING_PINS;
	}
	
	public int rollingBall () {
		int randomNum = (int)(Math.random()*bowlingPins+1);
		hitBowlingPin(randomNum);
		return randomNum;
	}
	
	private void hitBowlingPin (int hitCnt) {
		this.bowlingPins -= hitCnt;
	}
}
