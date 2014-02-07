package no.sintef.bvr.converters;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.BVRModel;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class BVR2GuidslTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException{
		List<String> ls = new FileUtility().traverseDirCollectFiles("TestData/Realistic");
		for(String file : ls){
			if(!file.endsWith(".m")) continue;
			if(file.contains("bvr.m")) continue;
			
			String bvrfile = file + ".bvr";
			String mfile = file;
			
			System.out.println("Testing Roundtrip: " + new File(mfile).getName());
			
			// Load Files
			GUIDSL gd = new GUIDSL(mfile);
			BVRModel bvr = gd.getGraphMLFM().getBVRModel();
			bvr.writeToFile(bvrfile);
			
			// Load again
			bvr = new BVRModel(bvrfile);
			gd = bvr.getGUIDSL();
			gd.writeToFile(bvrfile + ".m");
			GraphMLFM gmlfm = gd.getGraphMLFM();
			gmlfm.writeToFile(bvrfile + ".m.GraphML");
			bvr = gmlfm.getBVRModel();
			gd = bvr.getGUIDSL();
			gd.writeToFile(bvrfile + ".m.bvr.m");
			
			// Compare
			String s1 = new FileUtility().readFileAsString(bvrfile + ".m");
			String s2 = new FileUtility().readFileAsString(bvrfile + ".m.bvr.m");
			assertTrue(s1.equals(s2));
			
			//break;
		}
	}
}
