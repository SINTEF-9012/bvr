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
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;
import bvr.BvrFactory;
import bvr.ChoiceOccurrence;
import bvr.CompoundNode;
import bvr.VClassOccurrence;
import bvr.VType;


public final class VTypeFacade {
	
	final private String defaultName = "newType";
	private static int count = 0;
	
	public static VTypeFacade eINSTANCE = getInstance();
	
	private static VTypeFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new VTypeFacade();
		return eINSTANCE;
	}


	public VType appendVTypeCopoundNode(CompoundNode parent) {
		VType vType = BvrFactory.eINSTANCE.createVType();
		vType.setName(defaultName + count);
		count++;
		Context.eINSTANCE.getEditorCommands().addVTypeCompoundNode(parent, vType);
		return vType;
	}
	
	public void setChoiceOccurenceVType(ChoiceOccurrence choiceOccurence, VType vType) {
		Context.eINSTANCE.getEditorCommands().setChoiceOccurenceVType(choiceOccurence, vType);
	}


	public void setVClassOccurenceVType(VClassOccurrence vclassOccurence, VType vType) {
		Context.eINSTANCE.getEditorCommands().setVClassOccurenceVType(vclassOccurence, vType);
	}
}
