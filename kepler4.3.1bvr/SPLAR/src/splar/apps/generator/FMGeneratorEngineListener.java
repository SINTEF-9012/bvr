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
package splar.apps.generator;

public interface FMGeneratorEngineListener {
	public void generatingModel(String modelName);
	public void doneGeneratingModel(String modelName);
	public void modelAccepted(String modelName);
	public void modelRejected(String modelName, String reason);
	public void modelGenerationStarted();	
	public void modelGenerationEnded();	
	public void modelIsUnsat(String modelName);	
	public void modelIsSat(String modelName);	
	public void errorDuringGeneration(String modelName, String errorMessage);	
	public void generationCanceled();	
}
