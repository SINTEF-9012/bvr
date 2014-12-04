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
package no.sintef.bvr.thirdparty.editor;

import no.sintef.bvr.thirdparty.exception.NotSupportedLabelProvider;


import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor.IDProvider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;


public class BVRLabelProvider extends BVRAbstractBaseLabelProvider implements IColorProvider, IFontProvider {
	
	FontRegistry registry = new FontRegistry();
	
	public BVRLabelProvider(ILabelProvider _lableProvider) {
		super(_lableProvider);
		if(!((labelProvider instanceof IColorProvider && labelProvider instanceof IFontProvider) || labelProvider instanceof AdapterFactoryLabelProvider))
			throw new NotSupportedLabelProvider("label provider -> " + labelProvider + " <- must implement either IColorProvider and IFontProvider or AdapterFactoryLabelProvider to higlight elements ");
	}
	
	@Override
	public Font getFont(Object element) {
		Font font = getBoldFont(element);
		if(font == null) {
			if(labelProvider instanceof AdapterFactoryLabelProvider){
				font = ((AdapterFactoryLabelProvider) labelProvider).getFont(element);
			} else {
				font = ((IFontProvider) labelProvider).getFont(element);
			}
		}
		return font;
	}

	@Override
	public Color getBackground(Object element) {
		return (labelProvider instanceof AdapterFactoryLabelProvider) ?
				((AdapterFactoryLabelProvider) labelProvider).getBackground(element) :
					((IColorProvider) labelProvider).getBackground(element);
	}

	@Override
	public Color getForeground(Object element) {
		Color color = getFontForeground(element);
		if(color == null){
			if(labelProvider instanceof AdapterFactoryLabelProvider) {
				color = ((AdapterFactoryLabelProvider) labelProvider).getForeground(element);
			} else {
				color =  ((IColorProvider) labelProvider).getForeground(element);
			}
		}
		return color;
	}


	public Font getBoldFont(Object element) {
		if ((element instanceof EObject) && highlight.containsKey(IDProvider.getObjectId((EObject) element))) {
			return registry.getBold(Display.getCurrent().getSystemFont().getFontData()[0].getName());
		}
		return null;
	}

	public Color getFontForeground(Object element) {
		if(!(element instanceof EObject)) return null;
		if(!highlight.containsKey(IDProvider.getObjectId((EObject) element))) return null;
		
		switch (highlight.get(IDProvider.getObjectId((EObject) element))) {
		case IBVREnabledEditor.HL_PLACEMENT : 
			return IBVREnabledEditor.PLACEMENT;
		case IBVREnabledEditor.HL_PLACEMENT_OUT : 
			return IBVREnabledEditor.PLACEMENT_OUT;
		case IBVREnabledEditor.HL_PLACEMENT_IN : 
			return IBVREnabledEditor.PLACEMENT_IN;
		case IBVREnabledEditor.HL_PLACEMENT_IN_OUT : 
			return IBVREnabledEditor.PLACEMENT_IN_OUT;
		case IBVREnabledEditor.HL_REPLACEMENT : 
			return IBVREnabledEditor.REPLACEMENT;
		case IBVREnabledEditor.HL_REPLACEMENT_OUT : 
			return IBVREnabledEditor.REPLACEMENT_OUT;
		case IBVREnabledEditor.HL_REPLACEMENT_IN : 
			return IBVREnabledEditor.REPLACEMENT_IN;
		case IBVREnabledEditor.HL_REPLACEMENT_IN_OUT : 
			return IBVREnabledEditor.REPLACEMENT_IN_OUT;
		default : 
			return null;
		}
	}
}
