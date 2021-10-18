package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalFrameTest {
	
	private Frame normalFrame = new NormalFrame(0);
	
	@Test
	public void 점수계산후_턴이_줄어드는가() {
		//when
		normalFrame.playBowling(0);
		
		//then
		assertTrue(normalFrame.hasTurn());
	}
	@Test
	public void 스트라이크시_턴이_줄어드는가() {
		normalFrame.playBowling(10);
		
		assertFalse(normalFrame.hasTurn());
	}
	

}
