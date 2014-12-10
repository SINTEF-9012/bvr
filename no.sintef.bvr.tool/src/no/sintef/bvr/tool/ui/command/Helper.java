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
package no.sintef.bvr.tool.ui.command;

import java.util.List;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.Binding;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;

public class Helper {

	public static void bind(JComponent from, JComponent to, BVRModelPanel model, OPTION_STATE edgetype, List<Pair<JComponent, JComponent>> bindings) {
		if(from != null && to != null){
			Binding b = new Binding(edgetype);
			b.setFrom(from);
			b.setTo(to);
			model.addBinding(b);
			
			bindings.add(new Pair<JComponent, JComponent>(from, to));
		}
	}
	
	
}
