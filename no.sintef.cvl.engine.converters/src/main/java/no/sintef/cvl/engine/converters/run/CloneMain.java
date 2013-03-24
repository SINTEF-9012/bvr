package no.sintef.cvl.engine.converters.run;

import java.io.File;

import no.sintef.cvl.engine.converters.rls.CloneModel;


public class CloneMain {

	public static void main(String[] args) throws Exception {
		//final String folder = "src/main/resources/model/adjacent/exp1mod/";
		//final String folder = "src/main/resources/model/adjacent/exp1adjless/";
		//final String folder = "src/main/resources/model/estimate/size/exp2/";
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node.new.cvl"), 10);
		//con.run();
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 10, new String[]{"4"}, new String[]{"r4"});
		//con.dublicate();
		//con.dubllicateToBinding();
		final String folder = "src/main/resources/model/estimate/size/exp4/";
		CloneModel con = new CloneModel(new File(folder + "base_adjbinding_1.node"), new File(folder + "lib_adjbinding_1.node"), new File(folder + "node_new_adjbinding_1.cvl"), 5, "p1->r1", "p2->r2");
		con.createAdjFragment();
		System.out.println("Done");
	}
}
