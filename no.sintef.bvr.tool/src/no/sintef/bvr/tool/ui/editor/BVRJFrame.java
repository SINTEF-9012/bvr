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
package no.sintef.bvr.tool.ui.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class BVRJFrame extends JFrame {
	
	private BVRJFrame frame;
	private JTabbedPane tabbedPane;
	private static final String title = Messages.EDITOR_TITLE;
	
	public BVRJFrame() {
		super(title);
		frame = this;
		tabbedPane = new JTabbedPane();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setBackground(Color.WHITE);
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				String[] buttunTitles = {Messages.BUTTONS_TITLE_SAVE_AND_EXIT, Messages.BUTTONS_TITLE_EXIT, Messages.BUTTONS_TITLE_CANCEL};
				int result = JOptionPane.showOptionDialog(null, Messages.DIALOG_MSG_EXIT, Messages.DIALOG_TITLE_EXIT,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				        null, buttunTitles, buttunTitles[0]);
				if(result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION){
					try{
						if(result == JOptionPane.YES_OPTION){
							int componentCount = tabbedPane.getComponentCount();
							for(int index = 0; index<componentCount; index++){
								BVRToolModel model = Context.eINSTANCE.getBvrModels().get(index);
								StaticUICommands.saveModelToFile((JComponent) tabbedPane.getComponent(index), model, true);
							}
						}
						System.exit(0);
					}catch (Exception error){
						Context.eINSTANCE.logger.error("some error on Save", error);
						StaticUICommands.showMessageErrorDialog(frame, error, "Error:");
					}
				}
			}
		});
	}

	public JTabbedPane getJTabbedPane(){
		return tabbedPane;
	}

}
