package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 점수계산후_턴이_줄어드는가() {
		//given
		Frame frame = new Frame(0);
		
		//when
		frame.calculateScore(0);
		
		//then
		assertTrue(frame.hasTurn());
	}
	@Test
	public void 마지막프레임은_세번투구가능한가() {
		Frame frame = new Frame(9);
		
		frame.calculateScore(0);
		frame.calculateScore(1);
		
		assertTrue(frame.hasTurn());
		
		frame.calculateScore(2);
		
		assertFalse(frame.hasTurn());
	}
}
