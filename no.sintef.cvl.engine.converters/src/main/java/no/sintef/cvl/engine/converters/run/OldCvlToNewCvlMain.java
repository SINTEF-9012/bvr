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
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node5/node.cvl"), new File("src/main/resources/model/node5/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node6/nodde.cvl"), new File("src/main/resources/model/node6/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node10/node.cvl"), new File("src/main/resources/model/node10/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node7-1/node.cvl"), new File("src/main/resources/model/node7-1/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/node9-7/node.cvl"), new File("src/main/resources/model/node9-7/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/ARI.cvl"), new File("src/main/resources/model/ARI1.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/VM1.cvl"), new File("src/main/resources/model/PrinterPool.xmi"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/SafetyModule.cvl"), new File("src/main/resources/model/VM1.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/SafetyModule.cvl"), new File("src/main/resources/model/PrinterPool.xmi"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/adjacent/exp0/node.cvl"), new File("src/main/resources/model/adjacent/exp0/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/adjacent/exp1/node.cvl"), new File("src/main/resources/model/adjacent/exp0/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/realistic/iter0/SafetyModule.cvl"), new File("src/main/resources/model/realistic/iter0/SafetyModule.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/realistic/iter1/SafetyModule.cvl"), new File("src/main/resources/model/realistic/iter1/SafetyModule.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/realistic/iter2/SafetyModule.cvl"), new File("src/main/resources/model/realistic/iter2/SafetyModule.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/nodeNull/node.cvl"), new File("src/main/resources/model/nodeNull/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/nodeNtoM/exp0/node.cvl"), new File("src/main/resources/model/nodeNtoM/exp0/node.new.cvl"));
		//OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/nodeNtoM/exp1/node.cvl"), new File("src/main/resources/model/nodeNtoM/exp1/node.new.cvl"));
		OldCvlToNewCvl con = new OldCvlToNewCvl(new File("src/main/resources/model/adjacent/exp2/node.cvl"), new File("src/main/resources/model/adjacent/exp2/node.new.cvl"));
		con.run();
		//con.run1();		
	}

}
