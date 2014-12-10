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

import java.io.File;

import bvr.BVRModel;


public class BVREmptyModel extends BVRToolModel {

		
	public BVREmptyModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel();
		loadFilename = sf.getAbsolutePath();
		saved = false;
	}

	@Override
	public no.sintef.ict.splcatool.SPLCABVRModel getBVRM() {
		return bvrm;
	}

	@Override
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}
	
	public void setBVRModel(BVRModel bvrModel){
		((BVRInnerModel) bvrm).setBVRModel(bvrModel);
	}

	@Override
	public File getFile() {
		return f;
	}
	
	private class BVRInnerModel extends no.sintef.ict.splcatool.SPLCABVRModel {
		
		public void setBVRModel(BVRModel _model){
			model =_model;
		}

	}
}
