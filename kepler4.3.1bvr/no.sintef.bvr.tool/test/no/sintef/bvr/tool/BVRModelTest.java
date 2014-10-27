package no.sintef.bvr.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;

import org.junit.Test;

public class BVRModelTest {

	@Test
	public void testBVRModelFile() {
		BVRToolModel m = new BVRSimpleToolModel(new File("TestData/Artificial/Apl.m.bvr"));
		assertTrue(m != null);
	}

}
