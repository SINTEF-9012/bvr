package no.sintef.cvl.constraints.bcl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import no.sintef.ict.splcatool.CVLModel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.RuleNode;

import cvl.BCLConstraint;
import cvl.BCLExpression;
import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.MultiplicityInterval;
import cvl.VClassifier;
import cvl.Variable;
import cvl.CvlFactory;

public class Loader {
	public static void main(String [] args) throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test2.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build CVL
		CVLModel cm = new CVLModel();
		ConfigurableUnit cu = buildExampleCVL(cm);
		
		Variable minSpeed = CvlFactory.eINSTANCE.createVariable();
		//Variabletype minSpeedType = cvlFactory.eINSTANCE.createVariabletype();
		minSpeed.setName("minSpeed");
		//minSpeed.setType(minSpeedType);
		cu.getOwnedVSpec().add(minSpeed);
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = CvlFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, cu, true);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, cu);
		System.out.println(s);
	}

	private static ConfigurableUnit buildExampleCVL(CVLModel cm) {
		ConfigurableUnit cu = cm.getCU();
		
		Choice printer = CvlFactory.eINSTANCE.createChoice();
		printer.setName("printer");
		
		Choice fax = CvlFactory.eINSTANCE.createChoice();
		fax.setName("fax");
		
		Choice copier = CvlFactory.eINSTANCE.createChoice();
		copier.setName("copier");
		cu.getOwnedVSpec().add(copier);
		
		Choice scan = CvlFactory.eINSTANCE.createChoice();
		scan.setName("scan");
		cu.getOwnedVSpec().add(scan);
		
		Choice HighSpeed = CvlFactory.eINSTANCE.createChoice();
		HighSpeed.setName("HighSpeed");
		cu.getOwnedVSpec().add(HighSpeed);
		
		Choice Speed = CvlFactory.eINSTANCE.createChoice();
		Speed.setName("Speed");
		cu.getOwnedVSpec().add(Speed);
		
		Choice threshold = CvlFactory.eINSTANCE.createChoice();
		threshold.setName("threshold");
		cu.getOwnedVSpec().add(threshold);
		
		VClassifier PrinterPool = CvlFactory.eINSTANCE.createVClassifier();
		PrinterPool.setName("PrinterPool");
		MultiplicityInterval mi = CvlFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(0);
		mi.setUpper(-1);
		PrinterPool.setInstanceMultiplicity(mi);
		cu.getOwnedVSpec().add(PrinterPool);
		
		PrinterPool.getChild().add(printer);
		PrinterPool.getChild().add(fax);
		
		return cu;
	}
}
