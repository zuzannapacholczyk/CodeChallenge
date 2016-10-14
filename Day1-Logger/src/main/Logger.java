package main;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Logger implements LoggerI {

	private static Map<String, Logger> instances = new HashMap<>();
	private String key;

	public Logger(String key) {
		this.key = key;
	}

	public static Logger getInstance(String key) {
		Logger instance = instances.get(key);
		if (instance == null) {
			instance = new Logger(key);
			instances.put(key, instance);
		}

		return instance;
	}

	@Override
	public void log(Level level, String message, String... objects) {
		String preparedMessage = parseMessage(message, objects);
		
		String loggedMessage = LocalDateTime.now() + " " + this.key + " " + level + " " + preparedMessage;
		System.out.println(loggedMessage);
	}

	private String parseMessage(String message, String[] objects) {
		String[] messageSplit = message.split("\\[]");
		String preparedMessage = "";
		for (int i = 0; i < messageSplit.length; i++) {
			preparedMessage = preparedMessage.concat(messageSplit[i]);
			if (i < objects.length) {
				preparedMessage = preparedMessage.concat(objects[i]);
			}
		}
		return preparedMessage;
	}
}
