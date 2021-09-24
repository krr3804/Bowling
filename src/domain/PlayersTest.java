package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class PlayersTest {

	@Test
	public void testPlayers() {
		try {
			//when
			Players player = new Players("Test");
			
			//then
			Field field = player.getClass().getDeclaredField("name");
			field.setAccessible(true);
			
			String playerName = (String)field.get(player);
			
			assertEquals(playerName, "Test");
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
