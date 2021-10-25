package domain;

import java.util.ArrayList;

public class BowlingGame {
	private static final int FINAL_FRAME = 10;
	
	private Players player;
	private ArrayList<Frame> frames;
	private View view;
	
	public BowlingGame(Players player) {
		this.player = player;
		view = new View();
		frames = new ArrayList<Frame>();
		setFrames();
	}
	
	public void startGame() {
		for(Frame frame : frames) {
			playGame(frame);
		}
		view.showBowlingGame(frames, player);	
	}
	
	private void playGame(Frame frame) {
		Pins pin = new Pins();
		while(frame.hasTurn()) {
			int pinCnt = pin.rollingBall();
			frame.playBowling(pinCnt);
		}
		pin.resetPin();
	}
	private void setFrames() {
		for(int i=1; i<=FINAL_FRAME;i++) {
			if(i == FINAL_FRAME) {
				frames.add(new FinalFrame(i));
				return;
			}
			frames.add(new NormalFrame(i));
		}
	}
}
