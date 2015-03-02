package no.sintef.ict.splcatool.test.tool;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.SPLCABVRModel;

import org.junit.Before;
import org.junit.Test;

public class CSVGeneratingNotAllNodesResolved {

	private List<Map<String, Boolean>> expectedProds;
	private String expectedCSV[][];
	private Set<String> expectedFeatures;
	private String expectedCSVString;
	private SPLCABVRModel splcabvr;
	private BVRToolModel bvrmodel;

	@Before
	public void setUp() throws Exception {
		expectedProds = new ArrayList<Map<String, Boolean>>();
		Map<String, Boolean> resoluton = new HashMap<String, Boolean>();
		resoluton.put("TopChoice", true);
		resoluton.put("DirectOutputs", false);
		resoluton.put("DirectInputs", false);


		expectedProds.add(resoluton);

		assertTrue(expectedProds.size() == 1);

		expectedFeatures = new HashSet<String>();
		expectedFeatures.addAll(resoluton.keySet());

		assertTrue(expectedFeatures.size() == 3);

		expectedCSV = new String[][] { { "Feature\\Product", "TopChoice", "DirectOutputs", "DirectInputs" }, { "1", "X", "-", "-" } };

		expectedCSVString = "Feature\\Product;1;\nTopChoice;X;\nDirectOutputs;-;\nDirectInputs;-;\n";

		bvrmodel = new BVRSimpleToolModel(new File("TestData/Artificial/resDiffSize2.bvr"));
		splcabvr = bvrmodel.getBVRM();
	}

	@Test
	public void testConvertCSVArrayToString() {
		String result = splcabvr.convertCSVArrayToString(expectedCSV);
		assertEquals("CSV convertion is wrong", expectedCSVString, result);
	}

	@Test
	public void testGenerateCSVArry() {
		String[][] result = splcabvr.generateCSVArray(expectedProds);
		assertTrue("Incorrected CSV array: expected -> " + Arrays.deepToString(expectedCSV) + " actual -> " + Arrays.deepToString(result),
				isCSVArrayIsomorpthic(expectedCSV, result));
	}
	
	@Test
	public void testProductExtraction() {
		List<Map<String, Boolean>> prods = splcabvr.extractResolvedVSpecProducts();
		assertTrue("Actual product list is incorrect: expected -->" + expectedProds + " actual -->" + prods, doProductsEqual(expectedProds, prods));
	}

	private boolean doProductsEqual(List<Map<String, Boolean>> expected, List<Map<String, Boolean>> actual) {
		return Arrays.equals(expected.toArray(), actual.toArray());
	}
	
	
	private boolean isCSVArrayIsomorpthic(String[][] expected, String[][] actual) {
		return Arrays.deepEquals(expected, actual);
	}
	
	

}
