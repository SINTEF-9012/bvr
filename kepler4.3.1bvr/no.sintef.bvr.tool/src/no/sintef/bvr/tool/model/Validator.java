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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import bvr.Constraint;
import bvr.VSpecResolution;

public class Validator implements Validate {
	 
	private List<Constraint> invalidConstraints;
	private HashMap<Constraint, List<String>> results;
	
	public Validator() {
		invalidConstraints = new ArrayList<Constraint>();
		results = new HashMap<Constraint, List<String>>();
	}

	@Override
	public void validate(BVRToolModel toolModel, VSpecResolution vsr) {
		throw new UnimplementedBVRException("not implemented yet");
	}

	@Override
	public List<String> getConstraintValidationResultMessage(Constraint constraint) {
		return results.get(constraint);
	}

	@Override
	public List<Constraint> getInvalidConstraints() {
		return invalidConstraints;
	}

}
