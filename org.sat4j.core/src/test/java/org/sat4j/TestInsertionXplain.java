package org.sat4j;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ISolver;
import org.sat4j.tools.xplain.InsertionStrategy;
import org.sat4j.tools.xplain.Xplain;

public class TestInsertionXplain extends AbstractXplainTest {

	@Override
	protected Xplain<ISolver> getXplain() {
		Xplain<ISolver> solver = new Xplain<ISolver>(SolverFactory.newDefault());
		solver.setMinimizationStrategy(new InsertionStrategy());
		return solver;
	}

}
