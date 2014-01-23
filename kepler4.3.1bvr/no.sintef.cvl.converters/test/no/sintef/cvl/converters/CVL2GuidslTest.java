package no.sintef.cvl.converters;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.CVLModel;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class CVL2GuidslTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException{
		List<String> ls = new FileUtility().traverseDirCollectFiles("TestData/Realistic");
		for(String file : ls){
			if(!file.endsWith(".m")) continue;
			if(file.contains("cvl.m")) continue;
			
			String cvlfile = file + ".cvl";
			String mfile = file;
			
			System.out.println("Testing Roundtrip: " + new File(mfile).getName());
			
			// Load Files
			GUIDSL gd = new GUIDSL(mfile);
			CVLModel cvl = gd.getGraphMLFM().getCVLModel();
			cvl.writeToFile(cvlfile);
			
			// Load again
			cvl = new CVLModel(cvlfile);
			gd = cvl.getGUIDSL();
			gd.writeToFile(cvlfile + ".m");
			GraphMLFM gmlfm = gd.getGraphMLFM();
			gmlfm.writeToFile(cvlfile + ".m.GraphML");
			cvl = gmlfm.getCVLModel();
			gd = cvl.getGUIDSL();
			gd.writeToFile(cvlfile + ".m.cvl.m");
			
			// Compare
			String s1 = new FileUtility().readFileAsString(cvlfile + ".m");
			String s2 = new FileUtility().readFileAsString(cvlfile + ".m.cvl.m");
			assertTrue(s1.equals(s2));
			
			//break;
		}
	}
}
