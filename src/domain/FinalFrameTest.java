package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FinalFrameTest {
	private Frame finalFrame = new FinalFrame();
	
	@Test
	public void 마지막_프레임에서_스페어_획득시_3개의_턴을_가지고있는가() {
		finalFrame.playBowling(2);
		finalFrame.playBowling(8);
		
		assertTrue(finalFrame.hasTurn());
	}
	
	@Test
	public void 마지막_프레임에서_스트라이크_획득시_3개의_턴을_가지고있는가() {
		finalFrame.playBowling(10);
		
		assertTrue(finalFrame.hasTurn());
		
		finalFrame.playBowling(2);
		
		assertTrue(finalFrame.hasTurn());
		
		finalFrame.playBowling(3);
		
		assertFalse(finalFrame.hasTurn());
	}
	
	@Test
	public void 마지막_프레임에서_스트라이크_스페어_못했을시_턴이_2개인가() {
		finalFrame.playBowling(2);
		
		assertTrue(finalFrame.hasTurn());
		
		finalFrame.playBowling(2);
		
		assertFalse(finalFrame.hasTurn());
	}
}
