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
package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;



public class RefreshViewEvent extends AWTEvent {

	private static final long serialVersionUID = -8365918870492060388L;
	
	public  static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
	
	private BVRNotifiableController view;
	
	public RefreshViewEvent(Object target, BVRNotifiableController view) {
		super(target, EVENT_ID);
		this.view = view;
	}
	
	public void refreshView(){
		view.refresh();
	}
}
