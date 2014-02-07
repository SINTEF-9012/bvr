package no.sintef.bvr.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.tool.ui.loader.BVRModel;

import org.junit.Test;

public class BVRModelTest {

	@Test
	public void testBVRModelFile() {
		BVRModel m = new BVRModel(new File("TestData/Artificial/Apl.m.bvr"));
		assertTrue(m != null);
	}

}
