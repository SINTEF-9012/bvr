package no.sintef.cvl.engine.logging;

public interface Logger {

	public void error(String message);
	
	public void warn(String message);
	
	public void info(String message);
	
	public void debug(String message);
}
