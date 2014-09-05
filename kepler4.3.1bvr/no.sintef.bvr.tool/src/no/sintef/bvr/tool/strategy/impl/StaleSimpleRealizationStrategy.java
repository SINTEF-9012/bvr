package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;
import no.sintef.bvr.engine.adjacent.AdjacentFinder;
import no.sintef.bvr.engine.adjacent.AdjacentResolver;
import no.sintef.bvr.engine.error.ContainmentBVRModelException;
import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;

public class StaleSimpleRealizationStrategy implements RealizationStrategy {
	
	private EList<FragmentSubstitution> frgamentSusbstitutions; 
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> fsHMap;
	private AdjacentFinder adjacentFinder;
	private AdjacentResolver adjacentResolver;

	@Override
	public void deriveProduct(SymbolTable table) {
		frgamentSusbstitutions = new BasicEList<FragmentSubstitution>();
		BVRModel model = table.getBVRModel();
		EList<VariationPoint> ownedVariationPoints = model.getRealizationModel();
		for(VariationPoint vp : ownedVariationPoints){
			if(vp instanceof FragmentSubstitution){
				frgamentSusbstitutions.add((FragmentSubstitution) vp);
			}
		}
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		
		/*fsHMap = new HashMap<FragmentSubstitution, FragmentSubstitutionHolder>(); 
		ConfigurableUnit cu = table.getConfigurableUnit();
		EList<VariationPoint> ownedVariationPoints = cu.getOwnedVariationPoint();
		for(VariationPoint vp : ownedVariationPoints){
			if(vp instanceof FragmentSubstitution){
				FragmentSubstitution fs = (FragmentSubstitution) vp;
				try {
					fsHMap.put(fs, new FragmentSubstitutionHolder(fs));
				} catch (BasicBVREngineException e) {
					e.printStackTrace();
				}
			}
		}
		adjacentFinder = new AdjacentFinderImpl(new BasicEList<FragmentSubstitutionHolder>(fsHMap.values()));
		adjacentResolver = new AdjacentResolverImpl(adjacentFinder);*/
		
		this.resolveScope(table);
	}
	
	private void resolveScope(SymbolTable table){
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			this.resolveSymbol(symbol);
		}
		
		ArrayList<SymbolTable> underneathScopes = table.getChildren();
		for(SymbolTable scope : underneathScopes){
			this.resolveScope(scope);
		}
	}
	
	private void resolveSymbol(final Symbol symbol){
		BVRModel model = symbol.getScope().getBVRModel();
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(model.eResource().getResourceSet());
		EList<FragmentSubstitution> symbolsFragSubs = symbol.getFragmentSubstitutions();
		for(final FragmentSubstitution fs : symbolsFragSubs){
			/*final FragmentSubstitutionHolder fsH = fsHMap.get(fs);
			final FragmentSubOperation fso = new FragmentSubOperation(fsH);*/
			
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				protected void doExecute() {
					try {
						Context.eINSTANCE.getSubEngine().subsitute(fs, !symbol.getMulti());
					} catch (ContainmentBVRModelException e) {
						e.printStackTrace();
					}
					
					/*try {
						fso.execute(!symbol.getMulti());
						adjacentResolver.resolve(fsH);
						fso.checkConsistence();
					} catch (BasicBVREngineException e) {
						e.printStackTrace();
					}*/
				}
			});
		}
	}

}
