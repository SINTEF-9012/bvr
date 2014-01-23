package no.sintef.bvr.common.logging;

import java.util.Calendar;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.common.logging.Logger;


public class ConsoleLogger implements Logger {

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
		System.out.println("[CONSOLE LOGGER] " + calendar.getTime().toString() + ": " + message);
	}

	@Override
	public void error(String message, Throwable e) {
		String stackTrace = CommonUtility.getStackTraceAsString(e);
		error(message + " with the stack trace:\n" + stackTrace);
	}
	

}
