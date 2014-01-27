package no.sintef.bvr.converters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DummyCVLtoBVRConverter {

	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Usage: java -jar no.sintef.bvr.converters.jar <source file> <target file>");
			return;
		}
		File file = new File(args[0]);
		File fileBVR = new File(args[1]);
		try {			
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			
			FileWriter writerStream = new FileWriter(fileBVR);
			BufferedWriter writer = new BufferedWriter(writerStream);
			String output = "";
			while((line=reader.readLine()) != null){
				line = line.replaceAll("cvl", "bvr");
				output+=line + "\n";
			}
			writer.append(output);
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
