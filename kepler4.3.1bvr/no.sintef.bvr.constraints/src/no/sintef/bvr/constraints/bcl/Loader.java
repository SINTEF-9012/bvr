package no.sintef.bvr.constraints.bcl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import no.sintef.ict.splcatool.BVRModel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.RuleNode;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.MultiplicityInterval;
import bvr.VClassifier;
import bvr.Variable;
import bvr.BvrFactory;

public class Loader {
	public static void main(String [] args) throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test2.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		BVRModel cm = new BVRModel();
		ConfigurableUnit cu = buildExampleBVR(cm);
		
		Variable minSpeed = BvrFactory.eINSTANCE.createVariable();
		//Variabletype minSpeedType = bvrFactory.eINSTANCE.createVariabletype();
		minSpeed.setName("minSpeed");
		//minSpeed.setType(minSpeedType);
		cu.getOwnedVSpec().add(minSpeed);
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, cu, true);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, cu);
		System.out.println(s);
	}

	private static ConfigurableUnit buildExampleBVR(BVRModel cm) {
		ConfigurableUnit cu = cm.getCU();
		
		Choice printer = BvrFactory.eINSTANCE.createChoice();
		printer.setName("printer");
		
		Choice fax = BvrFactory.eINSTANCE.createChoice();
		fax.setName("fax");
		
		Choice copier = BvrFactory.eINSTANCE.createChoice();
		copier.setName("copier");
		cu.getOwnedVSpec().add(copier);
		
		Choice scan = BvrFactory.eINSTANCE.createChoice();
		scan.setName("scan");
		cu.getOwnedVSpec().add(scan);
		
		Choice HighSpeed = BvrFactory.eINSTANCE.createChoice();
		HighSpeed.setName("HighSpeed");
		cu.getOwnedVSpec().add(HighSpeed);
		
		Choice Speed = BvrFactory.eINSTANCE.createChoice();
		Speed.setName("Speed");
		cu.getOwnedVSpec().add(Speed);
		
		Choice threshold = BvrFactory.eINSTANCE.createChoice();
		threshold.setName("threshold");
		cu.getOwnedVSpec().add(threshold);
		
		VClassifier PrinterPool = BvrFactory.eINSTANCE.createVClassifier();
		PrinterPool.setName("PrinterPool");
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(0);
		mi.setUpper(-1);
		PrinterPool.setInstanceMultiplicity(mi);
		cu.getOwnedVSpec().add(PrinterPool);
		
		PrinterPool.getChild().add(printer);
		PrinterPool.getChild().add(fax);
		
		return cu;
	}
}
