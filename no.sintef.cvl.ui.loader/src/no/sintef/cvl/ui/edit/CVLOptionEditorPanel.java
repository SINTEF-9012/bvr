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
package no.sintef.cvl.ui.edit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import no.sintef.cvl.ui.command.event.SettingsToolEvent;
import no.sintef.cvl.ui.loader.CVLView;

import com.explodingpixels.macwidgets.plaf.HudCheckBoxUI;
import com.explodingpixels.macwidgets.plaf.HudLabelUI;


public class CVLOptionEditorPanel extends JPanel {
	
	protected CVLView view;
	
	protected JPanel top;
	protected JPanel bottom;
	
    public void addCenter(JComponent p) {
        this.add(p);
    }
    
    public void pack(int rows, int cols){
    	SpringUtilities.makeCompactGrid(top,
                rows, cols, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

    }

    public CVLOptionEditorPanel() {
        this.setOpaque(false);
        this.setBorder(null);
        
        top = new JPanel(new SpringLayout());
        top.setBorder(null);
        top.setOpaque(false);
        
        bottom = new JPanel();
        bottom.setBorder(null);
        bottom.setOpaque(false);
        
        this.addCenter(top);
        this.addCenter(bottom);
                
        JPanel p = new JPanel(new SpringLayout());
        p.setBorder(null);
        p.setOpaque(false);
        
        JLabel l = new JLabel("FromPlacement permutation", JLabel.TRAILING);
        l.setUI(new HudLabelUI());

        p.add(l);
        
        JCheckBox checkBoxFromPlacement = new JCheckBox();
        checkBoxFromPlacement.setUI(new HudCheckBoxUI());
        
        checkBoxFromPlacement.setSelected(SettingsToolEvent.SettingsCommand.getFromPlacementPermutation());
        
        l.setLabelFor(checkBoxFromPlacement);
        p.add(checkBoxFromPlacement);
        
        top.add(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        
        JPanel p1 = new JPanel(new SpringLayout());
        p1.setBorder(null);
        p1.setOpaque(false);
        
        JLabel l1 = new JLabel("ToReplacement permutation", JLabel.TRAILING);
        l1.setUI(new HudLabelUI());

        p1.add(l1);
        
        JCheckBox checkBoxToReplacement = new JCheckBox();
        checkBoxToReplacement.setUI(new HudCheckBoxUI());
        
        checkBoxToReplacement.setSelected(SettingsToolEvent.SettingsCommand.getToReplacementPermutation());
        
        l1.setLabelFor(checkBoxToReplacement);
        p1.add(checkBoxToReplacement);
        
        top.add(p1);
        SpringUtilities.makeCompactGrid(p1,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        pack(2,1);
        
        checkBoxFromPlacement.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED){
					SettingsToolEvent.SettingsCommand.setFromPlacementPermutation(true);
				}else if(event.getStateChange() == ItemEvent.DESELECTED){
					SettingsToolEvent.SettingsCommand.setFromPlacementPermutation(false);
				}
			}
		});
        
        checkBoxToReplacement.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED){
					SettingsToolEvent.SettingsCommand.setToReplacementPermutation(true);
				}else if(event.getStateChange() == ItemEvent.DESELECTED){
					SettingsToolEvent.SettingsCommand.setToReplacementPermutation(false);
				}
			}
		});  
    }
}