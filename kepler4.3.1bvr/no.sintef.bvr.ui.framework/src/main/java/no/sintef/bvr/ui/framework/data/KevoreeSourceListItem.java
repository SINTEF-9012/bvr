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
/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.sintef.bvr.ui.framework.data;

import com.explodingpixels.macwidgets.*;
import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: gnain
 * Date: 28/10/11
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
public class KevoreeSourceListItem extends SourceListItem {

    protected Object item;

    public KevoreeSourceListItem(String text) {
        super(text);
    }

    public KevoreeSourceListItem(String text, Icon icon) {
        super(text, icon);
    }

    public KevoreeSourceListItem(Object item) {
      this(item, null);
    }

    public KevoreeSourceListItem(Object item, Icon icon) {
        super(item.toString(), icon);
        this.item = item;
        /*if(NamedElement.class.isAssignableFrom(item.getClass())) {
            this.setText(((NamedElement)item).getName());
        }*/
    }

    public Object getKevoreeObject() {
        return item;
    }

}
