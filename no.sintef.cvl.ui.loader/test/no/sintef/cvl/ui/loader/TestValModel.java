package no.sintef.cvl.ui.loader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLException;
import no.sintef.ict.splcatool.CoveringArray;

public class TestValModel {
	@Test
	public void testValModel() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException, CVLException{
		assertTrue(validate(new File("../TestData/Artificial/valid.cvl")));
		
	}

	private boolean validate(File f) throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException, CVLException {
		CVLModel x = new CVLModel(f);
		no.sintef.ict.splcatool.CVLModel z = x.getCVLM();
		CoveringArray ca = z.getCoveringArray();
		CNF cnf = z.getGUIDSL().getSXFM().getCNF();
		boolean valid = CALib.verifyCA(cnf, ca, true, new ArrayList<String>());
		return valid;
	}
	
	@Test
	public void testValModel2() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException, CVLException{
		assertFalse(validate(new File("../TestData/Artificial/invalid.cvl")));
	}
}
