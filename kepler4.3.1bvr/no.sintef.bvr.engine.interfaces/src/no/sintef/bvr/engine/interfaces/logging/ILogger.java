package no.sintef.bvr.engine.interfaces.logging;

public interface ILogger {

	public void error(String message);
	
	public void warn(String message);
	
	public void info(String message);
	
	public void debug(String message);
}
