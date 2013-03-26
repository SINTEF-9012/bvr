package no.sintef.cvl.engine.converters.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		final String folder = "src/main/resources/model/estimate/size/exp7/";
		//final String folder = "";
		for(int i=1; i<21; i++){
			int times = 50 * i;
			CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), times, new String[]{"5"}, new String[]{"r5"});
			con.dublicate();
		}
		CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 1, "p1->r1", "p2->r2");
		con.createAdjBindings();
		for(int i=1; i<21; i++){
			int times = 50 * i;
			con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), times, "p1->r1", "p2->r2");
			con.createAdjBindings();
		}
		con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 1, "p1->r1", "p2->r2");
		con.createAdjFragment();
		for(int i=1; i<21; i++){
			int times = 50 * i;
			con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), times, "p1->r1", "p2->r2");
			con.createAdjFragment();
		}
		con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 1, new String[]{"5"}, new String[]{"r5"});
		con.dubllicateToBinding();
		for(int i=1; i<21; i++){
			int times = 50 * i;
			con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), times, new String[]{"5"}, new String[]{"r5"});
			con.dubllicateToBinding();
		}
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 300, new String[]{"5"}, new String[]{"r5"});
		//con.dublicate();
		//con.dubllicateToBinding();
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 300, "p1->r1", "p2->r2");
		//con.createAdjBindings();
		//final String folder = "src/main/resources/model/estimate/size/exp4/";
		//CloneModel con = new CloneModel(new File(folder + "base.node"), new File(folder + "lib.node"), new File(folder + "node_new.cvl"), 300, "p1->r1", "p2->r2");
		//con.createAdjFragment();
		System.out.println("Done");
		//compileResults("node_new_adjbinding_1.txt");
	}
	
	public static void compileResults(String file1) throws IOException{
		String folderNew = "D:/MSc/Thesis/masteroppgaven/data/processed";
		File dirNew = new File(folderNew);
		if(dirNew.isDirectory()){
			File[] oldFiles = dirNew.listFiles();
			for(File f : oldFiles){
				f.delete();
			}
			dirNew.delete();
		}
		
		String folder = "D:/MSc/Thesis/masteroppgaven/data/";
		File dir = new File(folder);
		File[] files = dir.listFiles();
		dirNew.mkdir();
		for(File file : files){
			//File file = new File(folder + file1);
			if(!file.exists()){
				System.out.println("WARNING: can not fine find :" + file.getName());
				return;
			}
			File file_res = new File(folderNew + "/" + file.getName());
			file_res.delete();
			try {
				file_res.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_res));
			
			String digit = "\\d+;";
			Pattern pattern_digit = Pattern.compile(digit);
			
			String pattern_finder = "Finder:\\s\\d+;";
			String pattern_one_pure_sub = "One\\spure\\ssubstitution:\\s\\d+;";
			String pattern_one_pure_res = "One\\spure\\sresolution:\\s\\d+;";
			String pattern_over_single_sub = "Overal\\ssingle\\ssubstitution:\\s\\d+;";
			String pattern_over_sub = "Overal\\ssubstitutions:\\s\\d+;";
			String finder = "Finder: ";
			String one_pure_sub = "One-pure-substitution: ";
			String one_pure_res = "One-pure-resolution: ";
			String over_single_sub = "Overal-single-substitution: ";
			String over_sub = "Overal-substitutions: ";
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null){
				if(line.matches(pattern_finder)){
					Matcher matcher = pattern_digit.matcher(line);
					if(!matcher.find()){
						System.out.println("Finder: can not find digit..." + file.getName());
						return;
					}
					String match = matcher.group();
					finder+=match;
				}
				if(line.matches(pattern_one_pure_sub)){
					Matcher matcher = pattern_digit.matcher(line);
					if(!matcher.find()){
						System.out.println("pattern_one_pure_sub: can not find digit..." + file.getName());
						return;
					}
					String match = matcher.group();
					one_pure_sub+=match;
				}
				if(line.matches(pattern_one_pure_res)){
					Matcher matcher = pattern_digit.matcher(line);
					if(!matcher.find()){
						System.out.println("pattern_one_pure_res: can not find digit..." + file.getName());
						return;
					}
					String match = matcher.group();
					one_pure_res+=match;
				}
				if(line.matches(pattern_over_single_sub)){
					Matcher matcher = pattern_digit.matcher(line);
					if(!matcher.find()){
						System.out.println("pattern_over_single_sub: can not find digit..." + file.getName());
						return;
					}
					String match = matcher.group();
					over_single_sub+=match;
				}
				if(line.matches(pattern_over_sub)){
					Matcher matcher = pattern_digit.matcher(line);
					if(!matcher.find()){
						System.out.println("pattern_over_sub: can not find digit..." + file.getName());
						return;
					}
					String match = matcher.group();
					over_sub+=match;
				}
			}
			br.close();
			
			bw.append(finder + "\n");
			bw.append(one_pure_sub + "\n");
			bw.append(one_pure_res + "\n");
			bw.append(over_single_sub + "\n");
			bw.append(over_sub + "\n");
			bw.close();
		}
	}
}
