package no.sintef.bvr.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.tool.ui.loader.BVRToolModel;

import org.junit.Test;

public class BVRModelTest {

	@Test
	public void testBVRModelFile() {
		BVRToolModel m = new BVRToolModel(new File("TestData/Artificial/Apl.m.bvr"));
		assertTrue(m != null);
	}

}
