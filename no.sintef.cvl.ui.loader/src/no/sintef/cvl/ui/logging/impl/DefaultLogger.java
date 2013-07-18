package no.sintef.cvl.ui.logging.impl;

import no.sintef.cvl.common.logging.Logger;

public class DefaultLogger implements Logger {

	@Override
	public void error(String message) {
		debug(message);
	}

	@Override
	public void warn(String message) {
		debug(message);
	}

	@Override
	public void info(String message) {
		debug(message);
	}

	@Override
	public void debug(String message) {
		System.out.println(message);
	}
}
