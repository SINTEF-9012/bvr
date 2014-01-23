package no.sintef.cvl.converters;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLModel;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class ConfGraphml2CVLTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException, CSVException{
		//int i = 0;
		
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			//if(i++ == 0) continue;
			
			if(!file.endsWith(".m.cvl") && !file.endsWith(".xml.cvl")) continue;
			if(!new File(file + ".conf.GraphML").exists()) continue;
			
			System.out.println("Injecting configurations of: " + new File(file).getName()+".conf.GraphML" + " into " + new File(file).getName());
			
			CVLModel cvl = new CVLModel(file);
			GraphMLFM gfm = new GraphMLFM(file + ".conf.GraphML");
			cvl.injectConfigurations(gfm);
			
			cvl.writeToFile(file + ".conf.cvl");
		}
	}
}
