package splar.plugins.configuration.tests.bdd.javabdd;

import org.junit.Test;

import splar.core.fm.configuration.ConfigurationEngine;
import splar.plugins.configuration.bdd.javabdd.BDDConfigurationEngine;
import splar.plugins.configuration.tests.ConfigurationEngineTest;

public class BDDConfigurationEngineTest extends ConfigurationEngineTest {
	
	public BDDConfigurationEngineTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected ConfigurationEngine createConfigurationEngine(String featureModelPath) throws Exception {
		return new BDDConfigurationEngine(featureModelPath);	
	}
	
	@Test
	@Override
	public void testAutoCompletion() {		
	}
	
	@Test
	@Override
	public void testToggle() {		
	}
	
	@Test
	@Override
	public void testConflictDetection() {		
	}

}
