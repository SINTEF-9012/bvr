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

package no.sintef.bvr.ui.editor.mvc.resolutionV2.commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import no.sintef.bvr.tool.controller.command.ResCommand;


public class CommandMouseListenerV2 extends MouseAdapter {

    private ResCommand leftClickCommand, rightClickCommand;

    public void setLeftClickCommand(ResCommand command) {
        this.leftClickCommand = command;
    }

    public void setRightClickCommand(ResCommand command) {
        this.rightClickCommand = command;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("MouseListener::MouseClicked::"+e.getButton());
        switch(e.getButton()) {
            case MouseEvent.BUTTON1 : {
                if(leftClickCommand != null) {
                    //System.out.println("MouseListener::MouseClicked::executeLeftClickCommand");
                    leftClickCommand.execute(/*e.getComponent()*/);
                }
            }break;
            case MouseEvent.BUTTON3 : {
                if(rightClickCommand != null) {
                    //System.out.println("MouseListener::MouseClicked::executeRightClickCommand");
                    rightClickCommand.execute(/*e.getComponent()*/);
                }
            }break;
        }
        
    }
}
