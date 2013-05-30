package no.sintef.cvl.converters;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.CSVException;
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

public class GuidslAndConf2CVLTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException, CSVException{
		//int i = 0;
		
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			//if(i++ == 0) continue;
			
			if(!file.endsWith(".m") && !file.endsWith(".xml")) continue;
			if(!new File(file + ".csv").exists()) continue;
			
			System.out.println("Converting configuration of: " + file);
			
			GUIDSL m = null;
			if(file.endsWith(".m")){
				m = new GUIDSL(new File(file));
			}
			if(file.endsWith(".xml")){
				SXFM sxfm = new SXFM(file);
				m = sxfm.getGUIDSL();
			}
			
			CoveringArray ca = new CoveringArrayFile(new File(file + ".csv"));
			GraphMLFM gmfm = m.getGraphMLFMConf(ca);
			
			gmfm.writeToFile(file + ".conf.GraphML");
		
			//break;
		}
	}
}
