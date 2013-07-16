package no.sintef.cvl.ui.logging.impl;

import no.sintef.cvl.ui.logging.Logger;

public final class Logging {
	
	private static final Logger LOGGER = new DefaultLogger();
	
	public static Logger getLogger(){
		return LOGGER;
	}

}
