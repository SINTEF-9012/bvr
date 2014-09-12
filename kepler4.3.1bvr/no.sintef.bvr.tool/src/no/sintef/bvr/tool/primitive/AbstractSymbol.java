package no.sintef.bvr.tool.primitive;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.VSpec;
import bvr.VSpecResolution;

public abstract class AbstractSymbol implements SymbolVSpec {

	protected VSpec vSpec;
	protected VSpecResolution vSpecResolution;
	protected EList<FragmentSubstitution> fragSubs;
	protected EList<FragmentSubstitution> fragSubsToExecute;
	protected SymbolVSpec parent;
	protected EList<SymbolVSpec> children;
	protected SymbolVSpecResolutionTable scope;
	protected boolean multi;
	protected HashMap<FragmentSubstitution, FragmentSubstitution> fragmentSubCopyMap;

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
	public void setParent(SymbolVSpec parent) {
		this.parent = parent;
	}

	@Override
	public SymbolVSpec getParent() {
		return this.parent;
	}

	@Override
	public void addChild(SymbolVSpec child) {
		this.children.add(child);
	}

	@Override
	public EList<SymbolVSpec> getChildren() {
		return this.children;
	}
	
	@Override
	public void setScope(SymbolVSpecResolutionTable table) {
		this.scope = table;
	}
	
	@Override
	public SymbolVSpecResolutionTable getScope() {
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
	
	@Override
	public FragmentSubstitution getFragmentSubstitutionCopy(FragmentSubstitution orignal) {
		return fragmentSubCopyMap.get(orignal);
	}
	
	@Override
	public void setFragmentSubstitutionCopy(FragmentSubstitution original,
			FragmentSubstitution copy) {
		fragmentSubCopyMap.put(original, copy);
	}
	
	@Override
	public EList<FragmentSubstitution> getFragmentSubstitutionsToExecute() {
		return fragSubsToExecute;
	}
	
	@Override
	public void addFragmentSubstitutionsToExecute(FragmentSubstitution fragment) {
		fragSubsToExecute.add(fragment);
	}
}
