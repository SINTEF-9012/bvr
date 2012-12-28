package org.sat4j;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ISolver;
import org.sat4j.tools.xplain.QuickXplain2001Strategy;
import org.sat4j.tools.xplain.Xplain;

public class TestQuickXplain2001 extends AbstractXplainTest {

	@Override
	protected Xplain<ISolver> getXplain() {
		Xplain<ISolver> solver = new Xplain<ISolver>(SolverFactory.newDefault());
		solver.setMinimizationStrategy(new QuickXplain2001Strategy());
		return solver;
	}

}
