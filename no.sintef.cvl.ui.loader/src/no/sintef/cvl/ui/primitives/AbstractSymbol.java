package no.sintef.cvl.ui.primitives;

import org.eclipse.emf.common.util.EList;

import cvl.FragmentSubstitution;
import cvl.VSpec;
import cvl.VSpecResolution;

public abstract class AbstractSymbol implements Symbol {

	protected VSpec vSpec;
	protected VSpecResolution vSpecResolution;
	protected EList<FragmentSubstitution> fragSubs;
	protected Symbol parent;
	protected EList<Symbol> children;
	protected SymbolTable scope;
	protected boolean multi;

	@Override
	public void setVSpec(VSpec vSpec) {
		this.vSpec = vSpec;
	}

	@Override
	public void setVSpecResolution(VSpecResolution vSpecResolution) {
		this.vSpecResolution = vSpecResolution;
	}

	@Override
	public VSpec getVSpec() {
		return this.vSpec;
	}

	@Override
	public VSpecResolution getVSpecResolution() {
		return this.vSpecResolution;
	}

	@Override
	public void addFragmentSubstitution(FragmentSubstitution fragmentSubstiotution) {
		this.fragSubs.add(fragmentSubstiotution);
	}

	@Override
	public EList<FragmentSubstitution> getFragmentSubstitutions() {
		return this.fragSubs;
	}

	@Override
	public void setParent(Symbol parent) {
		this.parent = parent;
	}

	@Override
	public Symbol getParent() {
		return this.parent;
	}

	@Override
	public void addChild(Symbol child) {
		this.children.add(child);
	}

	@Override
	public EList<Symbol> getChildren() {
		return this.children;
	}
	
	@Override
	public void setScope(SymbolTable table) {
		this.scope = table;
	}
	
	@Override
	public SymbolTable getScope() {
		return this.scope;
	}
	
	@Override
	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	@Override
	public boolean getMulti() {
		return this.multi;
	}
}
