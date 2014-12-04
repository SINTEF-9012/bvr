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


public interface EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	default public void exportAsPNGImage(SERIALIZABLE file) {
		throw new UnsupportedOperationException("not implemented");
	}

	default public String getModelFileLocation() {
		throw new UnsupportedOperationException("not implemented");
	}

	default public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void enableBatchCommandProcessing() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void disableBatchCommandProcessing() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void executeCommandBatch() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void setNodeName(GUI_NODE node, String name) {
		throw new UnsupportedOperationException("not implemented");
	}

	default boolean isSubstitutionEngineInitialized() {
		throw new UnsupportedOperationException("not implemented");
	};
}
