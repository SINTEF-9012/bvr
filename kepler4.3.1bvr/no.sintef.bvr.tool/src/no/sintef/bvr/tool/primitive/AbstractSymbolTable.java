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
package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashMap;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractSymbolTable implements SymbolVSpecResolutionTable {
	
	protected VSpecResolution tableId;
	protected HashMap<VSpecResolution, SymbolVSpec> table;
	protected SymbolVSpecResolutionTable parent;
	protected HashMap<VSpecResolution, SymbolVSpecResolutionTable> children;
	protected BVRModel bvrModel;

	@Override
	public SymbolVSpec lookup(VSpecResolution vSpecResolution) {
		return table.get(vSpecResolution);
	}
	
	@Override
	public SymbolVSpecResolutionTable lookupTable(VSpecResolution vSpecResolution) {
		return children.get(vSpecResolution);
	}

	@Override
	public void insert(SymbolVSpec vSpecResolutionSymbol) {
		table.put(vSpecResolutionSymbol.getVSpecResolution(), vSpecResolutionSymbol);
	}

	@Override
	public void delete(SymbolVSpec vSpecResolutionSymbol) {
		table.remove(vSpecResolutionSymbol.getVSpecResolution());
	}

	@Override
	public void setParent(SymbolVSpecResolutionTable table) {
		parent = table;
	}
	
	@Override
	public void setChild(SymbolVSpecResolutionTable table) {
		children.put(table.getTableId(), table);
	}
	
	@Override
	public VSpecResolution getTableId() {
		return tableId;
	}
	
	@Override
	public ArrayList<SymbolVSpecResolutionTable> getChildren() {
		return new ArrayList<SymbolVSpecResolutionTable>(children.values());
	}
	
	@Override
	public SymbolVSpecResolutionTable getParent() {
		return parent;
	}
	
	@Override
	public ArrayList<SymbolVSpec> getSymbols() {
		return new ArrayList<SymbolVSpec>(table.values());
	}
	
	@Override
	public void setBVRModel(BVRModel bvrModel) {
		this.bvrModel = bvrModel;
	}
	
	@Override
	public BVRModel getBVRModel() {
		return this.bvrModel;
	}
}
