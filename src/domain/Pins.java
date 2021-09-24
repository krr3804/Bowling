package domain;

public class Pins {

	private static final int MAX_BOWLING_PINS = 10;
	
	private int bowlingPins;
	
	public Pins() {
		this.bowlingPins = MAX_BOWLING_PINS;
	}
	
	public void rollingBall () {
		int randomNum = (int)(Math.random()*MAX_BOWLING_PINS+1);
		hitBowlingPin(randomNum);
	}
	
	private void hitBowlingPin (int hitCnt) {
		this.bowlingPins -= hitCnt;
	}
}
