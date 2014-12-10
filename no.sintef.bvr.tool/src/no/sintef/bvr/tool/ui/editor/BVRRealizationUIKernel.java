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
package no.sintef.bvr.tool.ui.editor;

import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;

public class BVRRealizationUIKernel<FRAGSUB_TABLE extends FragmentSubstitutionJTable,
		SUBFRAG_TABLE extends SubstitutionFragmentJTable,
		BINDING_TABLE extends BindingJTable> implements
			BVRRealizationUIKernelInterface<FRAGSUB_TABLE, SUBFRAG_TABLE, BINDING_TABLE> {
	
	private FRAGSUB_TABLE fst;
	private SUBFRAG_TABLE sft;
	private BINDING_TABLE bt;

	@Override
	public FRAGSUB_TABLE getFragmentSubstitutionTable() {
		return fst;
	}

	@Override
	public SUBFRAG_TABLE getSubsitutionFragmentTable() {
		return sft;
	}

	@Override
	public BINDING_TABLE getBindingTable() {
		return bt;
	}

	@Override
	public void setFragmentSubstitutionTable(FRAGSUB_TABLE table) {
		fst = table;
	}

	@Override
	public void setSubsitutionFragmentTable(SUBFRAG_TABLE table) {
		sft = table;
	}

	@Override
	public void setBindingTable(BINDING_TABLE table) {
		bt = table;
	}

}
