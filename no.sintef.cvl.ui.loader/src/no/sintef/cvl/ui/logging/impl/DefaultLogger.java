package no.sintef.cvl.ui.logging.impl;

import java.util.Calendar;

import no.sintef.cvl.ui.logging.Logger;

public class DefaultLogger implements Logger {

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
		System.out.println("[DEBUG] " + calendar.getTime().toString() + ": " + message);
	}
}
