package no.sintef.cvl.ui.algorithms;

import java.util.ArrayList;

import no.sintef.cvl.ui.exceptions.AbstractError;

import cvl.VariationPoint;

public abstract class BoundaryCalculatorStrategy {

	public abstract ArrayList<VariationPoint> getCompliedBoundaries(VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError;
}
