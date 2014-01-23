package no.sintef.bvr.converters;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.CVLModel;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GraphMLFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class GraphML2CVLTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException{
		List<String> ls = new FileUtility().traverseDirCollectFiles("TestData/Realistic");
		for(String file : ls){
			if(!file.endsWith(".GraphML")) continue;
			if(file.endsWith("Eshop-fm.xml.GraphML")) continue; //TODO Fix this: Has cycle
			System.out.println("Test converting to file: " + file + ".bvr");
			GraphMLFM gmfm = new GraphMLFM(file);
			CVLModel bvr = gmfm.getCVLModel();
			bvr.writeToFile(file + ".bvr");
		}
	}
}
