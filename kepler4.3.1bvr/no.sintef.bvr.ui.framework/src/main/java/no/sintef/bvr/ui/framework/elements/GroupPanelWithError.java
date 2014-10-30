package no.sintef.bvr.ui.framework.elements;
/**
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
 */

import no.sintef.bvr.ui.framework.IconPanel;

public class GroupPanelWithError extends IconPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8103246897625516598L;


	    public GroupPanelWithError() {
	    	super("/graphics/ErrorTriangle.png");
	    }
	    
	    public void setCardinality(int lower, int upper) {
	    	 setTitle(lower + ".." + upper);
	    	 if(upper == -1)
	    		 setTitle(lower + "..*");

	}

}
