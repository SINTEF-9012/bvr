package no.sintef.ict.splcatool;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CSVGenerating {

	private List<Map<String, Boolean>> prods;
	private String expectedCSV[][];
	private Set<String> expectedFeatures;
	private String expectedCSVString;
	private SPLCABVRModel splcabvr;

	@Before
	public void setUp() throws Exception {
		prods = new ArrayList<Map<String, Boolean>>();
		Map<String, Boolean> resoluton = new HashMap<String, Boolean>();
		resoluton.put("TopChoice", true);
		resoluton.put("DirectOutputs", true);
		resoluton.put("DirectInputs", false);

		Map<String, Boolean> resoluton1 = new HashMap<String, Boolean>();
		resoluton1.put("TopChoice", true);
		resoluton1.put("DirectOutputs", true);
		resoluton1.put("DirectInputs", true);

		prods.add(resoluton);
		prods.add(resoluton1);

		assertTrue(prods.size() == 2);

		expectedFeatures = new HashSet<String>();
		expectedFeatures.addAll(resoluton.keySet());
		expectedFeatures.addAll(resoluton1.keySet());

		assertTrue(expectedFeatures.size() == 3);

		expectedCSV = new String[][] { { "Feature\\Product", "TopChoice", "DirectOutputs", "DirectInputs" }, { "1", "X", "X", "-" }, { "2", "X", "X", "X" } };

		expectedCSVString = "Feature\\Product;1;2;\nTopChoice;X;X;\nDirectOutputs;X;X;\nDirectInputs;-;X;\n";

		splcabvr = new SPLCABVRModel();
	}

	@Test
	public void convertCSVArrayToString() {
		String result = splcabvr.convertCSVArrayToString(expectedCSV);
		assertEquals("CSV convertion is wrong", expectedCSVString, result);
	}

}
