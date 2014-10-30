package no.sintef.bvr.constraints.bcl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import no.sintef.ict.splcatool.BCLPrettyPrinter;
import no.sintef.ict.splcatool.SPLCABVRModel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.TestRig;
import org.antlr.v4.runtime.tree.RuleNode;
import org.junit.Test;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BvrFactory;

public class testBCL {

	@Test
	public void test() throws Exception {
		FileFilter ff = new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getAbsolutePath().endsWith(".bcl");
			}
		};
		
		// Redirect stderr
		PipedOutputStream pipeOutErr = new PipedOutputStream();
		PipedInputStream pipeInErr = new PipedInputStream(pipeOutErr);
		PrintStream oldErr = System.err;
		System.setErr(new PrintStream(pipeOutErr));

/*		PipedOutputStream pipeOutOut = new PipedOutputStream();
		PipedInputStream pipeInOut = new PipedInputStream(pipeOutOut);
		PrintStream oldOut = System.out;
		System.setOut(new PrintStream(pipeOutOut));
*/	
		//WARNING!
		//the test case fail due to test18.bcl which just contains "true". It seems like there is a problem in the BCL grammar(see BCL.g4) or parser since "true" is valid BCL expression in general,
		//but we get the following error line 1:4 -> mismatched input '<EOF>' expecting {'<', '<=', '=', '>', '>='}
		//should be fixed at some point
		int i = 0;
		for(File f : new File("TestData").listFiles(ff)){
			//System.out.println(f.getName() + ":" + f.getAbsolutePath());
			
			TestRig.main(new String [] {"BCL", "constraint", "-tree", f.getAbsolutePath()});
			
/*			i++;
			if(i > 1) break;
			*/
		}
		
		String s = "";
		while(pipeInErr.available() != 0){
			s += "" + (char)pipeInErr.read();
		}
		System.out.println(s);
		
		System.setErr(oldErr);
//		System.setOut(oldOut);		
		pipeInErr.close();
//		pipeInOut.close();
		
		assertEquals("", s);
	}
	
	@Test
	public void test1() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test1.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("fax implies printer", s);
	}
	
	@Test
	public void test2() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test2.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("(fax implies printer) and (copier implies (scan and printer))", s);
	}

	@Test
	public void test3() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test3.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("Speed = (minSpeed + 300)", s);
	}
	
	@Test
	public void test4() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test4.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("fax implies printer", s);
	}
	
	@Test
	public void test5() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test5.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("printer", s);
	}
	
	@Test
	public void test6() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test6.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("Speed > 1.2", s);
	}
	
	@Test
	public void test7() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test7.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("(HighSpeed and (threshold > 100)) implies EmergencyPower", s);
	}
	
	@Test
	public void test9() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test9.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test1.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("printer = \"Konika Minolta\"", s);
	}
	
	@Test
	public void test10() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test10.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("A or (not A)", s);
	}
	
	@Test
	public void test11() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test11.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("not ((not A) or (not A))", s);
	}
	
	@Test
	public void test12() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test12.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("(not A) or (isUndefined A)", s);
	}
	
	@Test
	public void test13() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test13.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("A implies (B or C)", s);
	}
	
	@Test
	public void test14() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test14.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("A or (B and C)", s);
	}
	
	@Test
	public void test15() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test15.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("((C + (A * B)) + C) < 3", s);
	}
	
	@Test
	public void test16() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test16.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("((C + (A * B)) + (- C)) < 3", s);
	}
	
	@Test
	public void test17() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test17.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		BCLExpression e = new BCLBuilder().recurse((RuleNode)root.getChild(0), 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("A < (B + 5)", s);
	}
	
	@Test
	public void test18() throws FileNotFoundException, IOException{
		CharStream input = new ANTLRInputStream(new FileInputStream("TestData/test18.bcl"));
		BCLLexer lexer = new BCLLexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		BCLParser parser = new BCLParser(tokens);
		
		// Build BVR
		SPLCABVRModel cm = new SPLCABVRModel("TestData/test2.xmi");
		//ConfigurableUnit cu = cm.getCU();
		BVRModel model = cm.getRootBVRModel();
		
		// Build model
		RuleNode root = parser.constraint().getRuleContext();
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		
		RuleNode ruleNode = (RuleNode)root.getChild(0);
		BCLExpression e = new BCLBuilder().recurse(ruleNode, 0, model, false);
		c.getExpression().add(e);
		
		// Pretty Print
		String s = new BCLPrettyPrinter().prettyPrint(e, model);
		
		assertEquals("true", s);
	}
}
