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

	private List<Map<String, Boolean>> expectedProds1;
	private String expectedCSV1[][];
	private Set<String> expectedFeatures1;
	private String expectedCSVString1;
	private SPLCABVRModel splcabvr1;
	private BVRToolModel bvrmodel1;

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
		splcabvr = bvrmodel.getSPLCABVRModel();

		expectedProds1 = new ArrayList<Map<String, Boolean>>();
		Map<String, Boolean> resoluton1 = new HashMap<String, Boolean>();
		resoluton1.put("TopChoice", true);
		resoluton1.put("DirectInputs0", false);
		resoluton1.put("DirectInputs1", false);
		resoluton1.put("DirectInputs2", false);
		resoluton1.put("DirectInputs3", false);
		resoluton1.put("DirectInputs4", false);
		resoluton1.put("DirectInputs5", false);
		resoluton1.put("DirectInputs6", false);

		expectedProds1.add(resoluton1);

		assertTrue(expectedProds1.size() == 1);

		expectedFeatures1 = new HashSet<String>();
		expectedFeatures1.addAll(resoluton1.keySet());

		assertTrue(expectedFeatures1.size() == 8);

		expectedCSV1 = new String[][] {
				{ "Feature\\Product", "TopChoice", "DirectInputs0", "DirectInputs1", "DirectInputs2", "DirectInputs3", "DirectInputs4", "DirectInputs5", "DirectInputs6" },
				{ "1", "X", "-", "-", "-", "-", "-", "-", "-" } };

		expectedCSVString1 = "Feature\\Product;1;\nTopChoice;X;\nDirectInputs0;-;\nDirectInputs1;-;\nDirectInputs2;-;\nDirectInputs3;-;\nDirectInputs4;-;\nDirectInputs5;-;\nDirectInputs6;-;\n";

		bvrmodel1 = new BVRSimpleToolModel(new File("TestData/Artificial/resDiffSize3.bvr"));
		splcabvr1 = bvrmodel1.getSPLCABVRModel();
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
	public void testProductExtraction() throws Exception {
		List<Map<String, Boolean>> prods = splcabvr.extractResolvedVSpecProducts();
		assertTrue("Actual product list is incorrect: expected -->" + expectedProds + " actual -->" + prods, doProductsEqual(expectedProds, prods));
		
		String[][] result = splcabvr.generateCSVArray(expectedProds);
		
		assertTrue("Incorrected CSV array: expected -> " + Arrays.deepToString(expectedCSV) + " actual -> " + Arrays.deepToString(result),
				isCSVArrayIsomorpthic(expectedCSV, result));
		
		String str = splcabvr.convertCSVArrayToString(result);
		
		assertEquals("String is incorrect", expectedCSVString, str);
	}

	@Test
	public void testProductExtraction1() throws Exception {
		List<Map<String, Boolean>> prods = splcabvr1.extractResolvedVSpecProducts();
		assertTrue("Actual product list is incorrect: expected -->" + expectedProds1 + " actual -->" + prods, doProductsEqual(expectedProds1, prods));
		
		String[][] result = splcabvr1.generateCSVArray(prods);
		
		assertTrue("Incorrected CSV array: expected -> " + Arrays.deepToString(expectedCSV1) + " actual -> " + Arrays.deepToString(result),
				isCSVArrayIsomorpthic(expectedCSV1, result));
		
		String str = splcabvr.convertCSVArrayToString(result);
		
		assertEquals("String is incorrect", expectedCSVString1, str);
	}

	private boolean doProductsEqual(List<Map<String, Boolean>> expected, List<Map<String, Boolean>> actual) {
		return Arrays.equals(expected.toArray(), actual.toArray());
	}

	private boolean isCSVArrayIsomorpthic(String[][] expected, String[][] actual) {
		return Arrays.deepEquals(expected, actual);
	}

}
