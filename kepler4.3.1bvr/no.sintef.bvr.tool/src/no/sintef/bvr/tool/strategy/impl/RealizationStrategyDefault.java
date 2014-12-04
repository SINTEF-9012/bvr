/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import bvr.FragmentSubstitution;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;

public class RealizationStrategyDefault implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolVSpecResolutionTable table) {
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		EList<SymbolVSpec> symbols = collectSymbols(table, new BasicEList<SymbolVSpec>());
		for(SymbolVSpec symbol : symbols){
			frgamentSusbstitutions.addAll(symbol.getFragmentSubstitutions());
		}
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		Context.eINSTANCE.performSubstitutions(symbols);
	}
	
	private HashSet<FragmentSubstitution> getFragmentSubstitutionsToResolve(SymbolVSpecResolutionTable table){
		HashSet<FragmentSubstitution> fss = new HashSet<FragmentSubstitution>();
		ArrayList<SymbolVSpec> symbols = table.getSymbols();
		for(SymbolVSpec symbol : symbols){
			fss.addAll(symbol.getFragmentSubstitutions());
		}
		ArrayList<SymbolVSpecResolutionTable> tables = table.getChildren();
		for(SymbolVSpecResolutionTable symbolTable : tables){
			fss.addAll(getFragmentSubstitutionsToResolve(symbolTable));
		}
		return fss;
	}
	
	private EList<SymbolVSpec> collectSymbols(SymbolVSpecResolutionTable table, EList<SymbolVSpec> result){
		result.addAll(table.getSymbols());
		for(SymbolVSpecResolutionTable sTable : table.getChildren()){
			result = collectSymbols(sTable, result);
		}
		return result;
	}
}
