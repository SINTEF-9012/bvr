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
package no.sintef.test.common;

import org.eclipse.core.resources.IFile;

public class TestResourceHolder {
	
	private String source;
	private String target;
	private IFile iFile;

	public TestResourceHolder(String src, String trg){
		setSource(src);
		setTarget(trg);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	} 
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public IFile getiFile() {
		return iFile;
	}

	public void setiFile(IFile iFile) {
		this.iFile = iFile;
	}
}
