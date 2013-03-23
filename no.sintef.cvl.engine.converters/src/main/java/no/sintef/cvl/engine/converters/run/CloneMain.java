package no.sintef.cvl.engine.converters.run;

import java.io.File;

import no.sintef.cvl.engine.converters.rls.CloneModel;


public class CloneMain {

	public static void main(String[] args) throws Exception {
		//final String folder = "src/main/resources/model/adjacent/exp1mod/";
		//final String folder = "src/main/resources/model/adjacent/exp1adjless/";
		final String folder = "src/main/resources/model/estimate/size/exp1/";
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node.new.cvl"), 10);
		//con.run();
		CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node.new.cvl"), 1000, new String[]{"2"}, new String[]{"r2"});
		con.dublicate();
		//con.dubllicateToBinding();
		System.out.println("Done");
	}
}
