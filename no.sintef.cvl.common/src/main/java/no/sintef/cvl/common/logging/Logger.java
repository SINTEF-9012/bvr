package no.sintef.cvl.common.logging;

public interface Logger {

	public void error(String message);
	
	public void error(String message, Throwable e);
	
	public void warn(String message);
	
	public void info(String message);
	
	public void debug(String message);
}
