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
package no.sintef.bvr.tool.interfaces.controller;



import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface VSpecControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> extends EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {
	
	public void addChoice(GUI_NODE parent);
	
	public void minimizeNode(GUI_NODE node);
	
	public void maximizeNode(GUI_NODE node);
	
	public Command createUpdateChoiceCommand(GUI_NODE node);
	
	public void updateVariable(MODEL_OBJECT variable, String name, String typeName);
	
	public void setNodeComment(GUI_NODE node, String comment);
	
	public String getNodesCommentText(GUI_NODE node);
	
	public void addVariable(GUI_NODE node);

	public Command createUpdateVClassifierCommand(GUI_NODE node);
	
	public void setVClassifierGroupMultiplicityUpperBound(GUI_NODE node, int upperBound);
	
	public void setVClassifierGroupMultiplicityLowerBound(GUI_NODE node, int lowerBound);
	
	public void addVClassifier(GUI_NODE node);
	
	public void addBCLConstraint(GUI_NODE node);
	
	public Command createUpdateBCLConstraintCommand(GUI_NODE node);
	
	public void updateBCLConstraint(GUI_NODE node, String strConstr);
	
	public void toggleChoiceOptionalMandotary(GUI_NODE node);
	
	public void cutNamedElement(GUI_NODE node);
	
	public void pastNamedElementAsChild(GUI_NODE node);
	
	public void pastNamedElementAsSibling(GUI_NODE node);
	
	public void setGroupMultiplicityAlternative(GUI_NODE node);
	
	public void setGroupMultiplicityNone(GUI_NODE node);
	
	public void setGroupMultiplicityOr(GUI_NODE node);
	
	public void setGroupMultiplicityCustom(GUI_NODE node, int lowerBound, int upperBound);
	
	public Command createUpdateBVRModelCommand(GUI_NODE node);
	
	public String getBCLConstraintString(GUI_NODE node);
	
	public void removeNamedElement(GUI_NODE node);

	public void editVType(MODEL_OBJECT vNode, MODEL_OBJECT vType);

	public void addVType(GUI_NODE node);

	public Command createUpdateChoiceOccurenceCommand(GUI_NODE elem);

	public void setChoiceOccurenceType(GUI_NODE node, String strType);

	public Command createUpdateVClassOccurenceCommand(GUI_NODE elem);

	public void setVClassOccurenceType(GUI_NODE parent, String typeName);

	void setVClassOccurenceGroupMultiplicityUpperBound(GUI_NODE node,
			int upperBound);

	void setVClassOccurenceGroupMultiplicityLowerBound(GUI_NODE node,
			int lowerBound);

	public void addChoiceOccurence(GUI_NODE parent);

	void addVClassOccurence(GUI_NODE parent);
}
