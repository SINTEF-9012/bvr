package no.sintef.cvl.engine.logging.impl;

import java.util.Calendar;

import no.sintef.cvl.common.logging.Logger;


public class ConsoleEngineLogger implements Logger {
	
	private static Calendar calendar = Calendar.getInstance();

	@Override
	public void error(String message) {
		this.debug(message);
	}

	@Override
	public void warn(String message) {
		this.debug(message);
	}

	@Override
	public void info(String message) {
		this.debug(message);
	}

	@Override
	public void debug(String message) {
		System.out.println("[DEBUG ENGINE] " + calendar.getTime().toString() + ": " + message);
	}

}
