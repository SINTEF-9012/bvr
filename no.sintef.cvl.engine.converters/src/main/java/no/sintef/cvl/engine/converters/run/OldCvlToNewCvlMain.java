package no.sintef.cvl.engine.converters.run;

import java.io.File;
import java.io.IOException;

import no.sintef.cvl.engine.converters.rls.OldCvlToNewCvl;

public class OldCvlToNewCvlMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/VM1.cvl"), new File("src/main/resources/model/VM1.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node1/node.cvl"), new File("src/main/resources/model/node1/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node2/node.cvl"), new File("src/main/resources/model/node2/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node3/node.cvl"), new File("src/main/resources/model/node3/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node4/node.cvl"), new File("src/main/resources/model/node4/node.new.cvl"));
		OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node5/node.cvl"), new File("src/main/resources/model/node5/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/ARI.cvl"), new File("src/main/resources/model/ARI1.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/VM1.cvl"), new File("src/main/resources/model/PrinterPool.xmi"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/SafetyModule.cvl"), new File("src/main/resources/model/VM1.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/SafetyModule.cvl"), new File("src/main/resources/model/PrinterPool.xmi"));
		con.run();
		//con.run1();
	}

}