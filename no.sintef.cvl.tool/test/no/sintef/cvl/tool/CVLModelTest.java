package no.sintef.cvl.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.cvl.tool.ui.loader.CVLModel;

import org.junit.Test;

public class CVLModelTest {

	@Test
	public void testCVLModelFile() {
		CVLModel m = new CVLModel(new File("TestData/Artificial/Apl.m.cvl"));
		assertTrue(m != null);
	}

}
