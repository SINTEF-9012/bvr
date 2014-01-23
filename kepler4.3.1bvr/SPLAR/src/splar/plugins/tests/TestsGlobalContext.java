package splar.plugins.tests;

public class TestsGlobalContext {

	// Testing Reasoning Interfaces
	// Path to feature model test files
	public static String consistentFeatureModelXMLFile = "file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\tests\\test_fm_consistent.xml"; 
	public static String inconsistentFeatureModelXMLFile = "file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\tests\\test_fm_inconsistent.xml"; 

	// Features @ test_fm_consistent.xml
	public static final String core[] = {"r","a","a3"};
	public static final String dead[] = {"c1","c11","c12"};
	public static final String free[] = {"g_a1","g_a2","a4","b","b1","b2","c","c2"};
	
	// Testing ConfigurationEngines
	public static String configurationFeatureModelXMLFile = "file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\tests\\test_fm_configuration.xml"; 
	
	public static String initial_feature_model_configuration_state[] = {"+r","+a","?g_a1","?g_a2","+a3","?a4","?b","?b1","?b2","?b3","?c","?c1","?c11","?c12","?c2"};

}
