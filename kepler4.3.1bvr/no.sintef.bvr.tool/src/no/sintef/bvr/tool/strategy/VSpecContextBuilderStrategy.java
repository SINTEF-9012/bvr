package no.sintef.bvr.tool.strategy;

import bvr.CompoundNode;
import bvr.NamedElement;

public interface VSpecContextBuilderStrategy {

		public void testVSpec(NamedElement parent, CompoundNode child);
		
		public void reset();
}
