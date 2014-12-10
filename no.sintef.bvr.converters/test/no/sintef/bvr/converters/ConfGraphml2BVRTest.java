package no.sintef.bvr.converters;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.BVRModel;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GraphMLFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class ConfGraphml2BVRTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException, CSVException{
		//int i = 0;
		
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			//if(i++ == 0) continue;
			
			if(!file.endsWith(".m.bvr") && !file.endsWith(".xml.bvr")) continue;
			if(!new File(file + ".conf.GraphML").exists()) continue;
			
			System.out.println("Injecting configurations of: " + new File(file).getName()+".conf.GraphML" + " into " + new File(file).getName());
			
			BVRModel bvr = new BVRModel(file);
			GraphMLFM gfm = new GraphMLFM(file + ".conf.GraphML");
			bvr.injectConfigurations(gfm);
			
			bvr.writeToFile(file + ".conf.bvr");
		}
	}
}
