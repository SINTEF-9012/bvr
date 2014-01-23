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
package no.sintef.bvr.tool.ui.edit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.SettingsToolEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

import com.explodingpixels.macwidgets.plaf.HudCheckBoxUI;
import com.explodingpixels.macwidgets.plaf.HudLabelUI;


public class BVROptionEditorPanel extends JPanel {
	
	protected BVRView view;
	
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

    public BVROptionEditorPanel() {
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
        
        JLabel l = new JLabel(Constants.SETTINGS_FROMPLACEMENT_PERMUTATION, JLabel.TRAILING);
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
        
        JLabel l1 = new JLabel(Constants.SETTINGS_TOREPLACEMENT_PERMUTATION, JLabel.TRAILING);
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
        
        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
        
        JLabel l2 = new JLabel(Constants.SETTINGS_CONTAINMENT_SELECTION_MODE, JLabel.TRAILING);
        l2.setUI(new HudLabelUI());

        p2.add(l2);
        
        JCheckBox checkBoxContainment = new JCheckBox();
        checkBoxContainment.setUI(new HudCheckBoxUI());
        
        checkBoxContainment.setSelected(SettingsToolEvent.SettingsCommand.getContainmentSelectionMode());
        
        l2.setLabelFor(checkBoxContainment);
        p2.add(checkBoxContainment);
        
        top.add(p2);
        SpringUtilities.makeCompactGrid(p2,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        JPanel p3 = new JPanel(new SpringLayout());
        p3.setBorder(null);
        p3.setOpaque(false);
        
        JLabel l3 = new JLabel(Constants.SETTINGS_HIGHLIGHTING_MODE, JLabel.TRAILING);
        l3.setUI(new HudLabelUI());

        p3.add(l3);
        
        JCheckBox checkBoxHighlighting = new JCheckBox();
        checkBoxHighlighting.setUI(new HudCheckBoxUI());
        
        checkBoxHighlighting.setSelected(SettingsToolEvent.SettingsCommand.getHighlightingMode());
        
        l3.setLabelFor(checkBoxHighlighting);
        p3.add(checkBoxHighlighting);
        
        top.add(p3);
        SpringUtilities.makeCompactGrid(p3,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        pack(4,1);
        
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
        
        checkBoxContainment.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED){
					SettingsToolEvent.SettingsCommand.setContainmentSelectionMode(true);
				}else if(event.getStateChange() == ItemEvent.DESELECTED){
					SettingsToolEvent.SettingsCommand.setContainmentSelectionMode(false);
				}
			}
		});
        
        checkBoxHighlighting.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED){
					SettingsToolEvent.SettingsCommand.setHighlightingMode(true);
				}else if(event.getStateChange() == ItemEvent.DESELECTED){
					SettingsToolEvent.SettingsCommand.setHighlightingMode(false);
				}
			}
		});
    }
}