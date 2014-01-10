package no.sintef.cvl.converters;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;
import org.xml.sax.SAXException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class Guidsl2GraphMLTest {
	@Test
	public void test() throws UnsupportedModelException, IOException, FeatureModelException, TransformerException, ParserConfigurationException, SAXException{
		//int i = 0;
		
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			//if(i++ == 0) continue;
			
			if(!file.endsWith(".m") && !file.endsWith(".xml")) continue;
			
			System.out.println("Test converting of file: " + file);
			
			GUIDSL m = null;
			if(file.endsWith(".m")){
				m = new GUIDSL(new File(file));
			}
			if(file.endsWith(".xml")){
				SXFM sxfm = new SXFM(file);
				m = sxfm.getGUIDSL();
			}
			
			GraphMLFM gmfm = m.getGraphMLFM();
			
			gmfm.writeToFile(file + ".GraphML");
			
			//break;
		}
	}
}
