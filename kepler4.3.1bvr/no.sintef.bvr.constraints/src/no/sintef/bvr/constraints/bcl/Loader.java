package no.sintef.bvr.constraints.bcl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import no.sintef.ict.splcatool.BCLPrettyPrinter;
import no.sintef.ict.splcatool.SPLCABVRModel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.RuleNode;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.Choice;
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
		SPLCABVRModel cm = new SPLCABVRModel();
		//ConfigurableUnit cu = buildExampleBVR(cm);
		BVRModel model = buildExampleBVR(cm);
		
		Variable minSpeed = BvrFactory.eINSTANCE.createVariable();
		//Variabletype minSpeedType = bvrFactory.eINSTANCE.createVariabletype();
		minSpeed.setName("minSpeed");
		//minSpeed.setType(minSpeedType);
		//cu.getOwnedVSpec().add(minSpeed);
		model.getVariabilityModel().getVariable().add(minSpeed);
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, true);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		System.out.println(s);
	}

	private static BVRModel buildExampleBVR(SPLCABVRModel cm) {
		BVRModel bvrModel = cm.getRootBVRModel();
		
		Choice office = BvrFactory.eINSTANCE.createChoice();
		office.setName("office");
		bvrModel.setVariabilityModel(office);
		
		Choice printer = BvrFactory.eINSTANCE.createChoice();
		printer.setName("printer");
		
		Choice fax = BvrFactory.eINSTANCE.createChoice();
		fax.setName("fax");
		
		Choice copier = BvrFactory.eINSTANCE.createChoice();
		copier.setName("copier");
		office.getMember().add(copier);
		
		Choice scan = BvrFactory.eINSTANCE.createChoice();
		scan.setName("scan");
		office.getMember().add(scan);
		
		Choice HighSpeed = BvrFactory.eINSTANCE.createChoice();
		HighSpeed.setName("HighSpeed");
		office.getMember().add(HighSpeed);
		
		Choice Speed = BvrFactory.eINSTANCE.createChoice();
		Speed.setName("Speed");
		office.getMember().add(Speed);
		
		Choice threshold = BvrFactory.eINSTANCE.createChoice();
		threshold.setName("threshold");
		office.getMember().add(threshold);
		
		VClassifier PrinterPool = BvrFactory.eINSTANCE.createVClassifier();
		PrinterPool.setName("PrinterPool");
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(0);
		mi.setUpper(-1);
		PrinterPool.setInstanceMultiplicity(mi);
		office.getMember().add(PrinterPool);
		
		PrinterPool.getMember().add(printer);
		PrinterPool.getMember().add(fax);
		
		return bvrModel;
	}
}
