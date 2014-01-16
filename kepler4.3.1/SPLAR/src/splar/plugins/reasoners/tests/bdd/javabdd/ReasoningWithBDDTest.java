package splar.plugins.reasoners.tests.bdd.javabdd;

import splar.core.fm.FeatureModel;
import splar.core.fm.reasoning.FMReasoningInterface;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.tests.FMReasoningInterfaceTest;

public class ReasoningWithBDDTest extends FMReasoningInterfaceTest {
	
	public ReasoningWithBDDTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected FMReasoningInterface createReasoner(FeatureModel model) {
		int bddNodeNum = 10000, bddCacheSize = 10000;
		new FTPreOrderTraversalHeuristic("BDDVarOrderHeuristic", model);
		VariableOrderingHeuristic heuristic = VariableOrderingHeuristicsManager.createHeuristicsManager().getHeuristic("BDDVarOrderHeuristic");
		return new FMReasoningWithBDD(model, heuristic, bddNodeNum, bddCacheSize, 60000, "pre-order");
	}
}
