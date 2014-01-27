package splar.plugins.configuration.tests.sat.sat4j;

import splar.core.fm.configuration.ConfigurationEngine;
import splar.plugins.configuration.sat.sat4j.SATConfigurationEngine;
import splar.plugins.configuration.tests.ConfigurationEngineTest;


public class SATConfigurationEngineTest extends ConfigurationEngineTest {

	public SATConfigurationEngineTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected ConfigurationEngine createConfigurationEngine(String featureModelPath) throws Exception {
		return new SATConfigurationEngine(featureModelPath);	
	}
}
