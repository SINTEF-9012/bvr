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
package splar.core.constraints;

public interface BooleanVariableInterface {	
	public String getID();
	public void assignValue(int value);
	public void assignValue(int value, BooleanVariableInterface propagationVar);
	public boolean isPropagation();
	public BooleanVariableInterface getPropagationVariable();
	public int getValue();
	public boolean isInstantiated();
	public void resetValue();
	public void setImmutable(boolean immutable);
	public boolean isImmutable();
	public void attachData(Object object);
	public Object getAttachedData();
	public void resetAttachedData();	
}
