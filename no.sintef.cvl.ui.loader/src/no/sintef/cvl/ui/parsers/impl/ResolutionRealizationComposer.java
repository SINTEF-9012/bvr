package no.sintef.cvl.ui.parsers.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VInstance;
import cvl.VSpecResolution;
import cvl.VariationPoint;
import no.sintef.cvl.ui.parsers.Parser;
import no.sintef.cvl.ui.primitives.Symbol;
import no.sintef.cvl.ui.primitives.SymbolTable;
import no.sintef.cvl.ui.primitives.impl.VSpecResolutionSymbol;
import no.sintef.cvl.ui.primitives.impl.VSpecResolutionSymbolTable;

public class ResolutionRealizationComposer implements Parser {

	private EList<VariationPoint> vps;
	private BasicEList<FragmentSubstitution> fss;

	public ResolutionRealizationComposer(ConfigurableUnit cu) {
		vps = cu.getOwnedVariationPoint();
		fss = new BasicEList<FragmentSubstitution>();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fss.add((FragmentSubstitution) vp);
			}
		}
	}

	public SymbolTable buildSymbolTable(VSpecResolution vSpecResolution) {
		VSpecResolutionSymbolTable table = new VSpecResolutionSymbolTable(vSpecResolution);
		VSpecResolutionSymbol symbol = new VSpecResolutionSymbol(vSpecResolution);
		this.parse(symbol, table);
		return table;
	}

	private boolean parse(Symbol symbol, SymbolTable table) {
		VSpecResolution vSpecResolution = symbol.getVSpecResolution();
		VSpecResolutionSymbolTable subTable;
		if(vSpecResolution instanceof ChoiceResolutuion){
			if(!((ChoiceResolutuion) vSpecResolution).isDecision()){
				return false;
			}
		}else if(vSpecResolution instanceof VInstance){
			subTable = new VSpecResolutionSymbolTable(vSpecResolution);
			subTable.setParent(table);
			table.setChild(subTable);
			table = subTable;
		}else{
			throw new UnsupportedOperationException("we can not handle VSpecResolution of this kind");
		}
		
		for(FragmentSubstitution fs : fss){
			if(fs.getBindingVSpec() != null && fs.getBindingVSpec().equals(symbol)){
				symbol.addFragmentSubstitution(fs);
			}
		}
		
		symbol.setScope(table);
		table.insert(symbol);
		
		EList<VSpecResolution> children = vSpecResolution.getChild();
		for(VSpecResolution child : children){
			VSpecResolutionSymbol childSymbol = new VSpecResolutionSymbol(child);
			childSymbol.setParent(symbol);
			boolean isDecision = this.parse(childSymbol, table);
			if(isDecision)
				symbol.addChild(childSymbol);
		}
		return true;
	}

}
