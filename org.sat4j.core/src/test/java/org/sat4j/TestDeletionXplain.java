package org.sat4j;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ISolver;
import org.sat4j.tools.xplain.DeletionStrategy;
import org.sat4j.tools.xplain.Xplain;

public class TestDeletionXplain extends AbstractXplainTest {

	@Override
	protected Xplain<ISolver> getXplain() {
		Xplain<ISolver> solver = new Xplain<ISolver>(SolverFactory.newDefault());
		solver.setMinimizationStrategy(new DeletionStrategy());
		return solver;
	}

}
