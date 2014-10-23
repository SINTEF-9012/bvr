package no.sintef.bvr.constraints.strategy;


import bvr.Target;
import bvr.VSpec;

public abstract class AbstractBCLBuilderStrategy {

	abstract public Target getVSpecTarget(VSpec node);
}
