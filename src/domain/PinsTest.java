package domain;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class PinsTest {

	@Test
	public void testHitBowlingPins() {
		try {
			//given
			Pins pins = new Pins();
			
			Method method = pins.getClass().getDeclaredMethod("hitBowlingPin", int.class);
			method.setAccessible(true);
			
			//when
			method.invoke(pins,3);
			
			//then
			Field field = pins.getClass().getDeclaredField ("bowlingPins");
			field.setAccessible(true);
			 
			int resultPin = (int)field.get(pins);
			
			assertEquals(resultPin, 7);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
