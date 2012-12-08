package no.sintef.cvl.engine.logging.impl;

import java.util.Calendar;

import no.sintef.cvl.engine.logging.Logger;

public class ConsoleLogger implements Logger {
	
	private static Calendar calendar = Calendar.getInstance();

	@Override
	public void error(String message) {
		System.out.println("[ERROR] " + calendar.getTime().toString() + ": " + message);
	}

	@Override
	public void warn(String message) {
		System.out.println("[WARNING] " + calendar.getTime().toString() + ": " + message);
	}

	@Override
	public void info(String message) {
		System.out.println("[INFO] " + calendar.getTime().toString() + ": " + message);
	}

}
