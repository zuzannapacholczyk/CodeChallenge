package test;

import org.junit.Test;

import main.Level;
import main.Logger;

public class LoggerTest {
	
	@Test
	public void shouldPrepareMessage() {
		Logger logger = Logger.getInstance("com.Test");
		logger.log(Level.ERROR, "Test message []", "Ala Ma kota");
	}
}
