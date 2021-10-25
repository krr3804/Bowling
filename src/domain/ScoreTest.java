package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class ScoreTest {
	private Score normalFrameScore = new Score(2);
	private Score finalFrameScore = new Score(3);
	
	@Test
	public void NORMAL_프레임_점수저장() throws NoSuchFieldException, IllegalAccessException {
		normalFrameScore.setScore(6, 2);
		normalFrameScore.setScore(4, 1);
		
		Field firstShot = normalFrameScore.getClass().getDeclaredField("firstShot");
		Field secondShot = normalFrameScore.getClass().getDeclaredField("secondShot");
		
		firstShot.setAccessible(true);
		secondShot.setAccessible(true);
		
		int result1 = (int)firstShot.get(normalFrameScore);
		int result2 = (int)secondShot.get(normalFrameScore);
		
		assertEquals(result1, 6);
		assertEquals(result2, 4);
	}
	
	@Test
	public void FINAL_프레임_점수저장() throws NoSuchFieldException, IllegalAccessException {
		finalFrameScore.setScore(4, 3);
		finalFrameScore.setScore(6, 2);
		finalFrameScore.setScore(5, 1);
		
		Field firstShot = finalFrameScore.getClass().getDeclaredField("firstShot");
		Field secondShot = finalFrameScore.getClass().getDeclaredField("secondShot");
		Field finalShot = finalFrameScore.getClass().getDeclaredField("finalShot");
		
		firstShot.setAccessible(true);
		secondShot.setAccessible(true);
		finalShot.setAccessible(true);
		
		int result1 = (int)firstShot.get(finalFrameScore);
		int result2 = (int)secondShot.get(finalFrameScore);
		int result3 = (int)finalShot.get(finalFrameScore);
		
		assertEquals(result1, 4);
		assertEquals(result2, 6);
		assertEquals(result3, 5);
	}
	@Test
	public void FINAL_프레임_스트라이크_성공 () {
		finalFrameScore.setScore(10, 3);
		
		assertTrue(finalFrameScore.hasFinalTurn());
	}
	@Test
	public void FINAL_프레임_스트라이크_스페어_실패 () {
		finalFrameScore.setScore(2, 3);
		finalFrameScore.setScore(4, 2);
		
		assertFalse(finalFrameScore.hasFinalTurn());
	}
	@Test
	public void FINAL_프레임_스페어_성공 () {
		finalFrameScore.setScore(1, 3);
		
		assertFalse(finalFrameScore.hasFinalTurn());
		
		finalFrameScore.setScore(9, 2);
		
		assertTrue(finalFrameScore.hasFinalTurn());
	}
}
