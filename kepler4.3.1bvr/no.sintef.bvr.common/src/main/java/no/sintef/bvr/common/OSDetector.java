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
package no.sintef.bvr.common;

import java.util.Locale;

public final class OSDetector {
  /**
   * types of Operating Systems
   */
  public enum OSType {
    Windows, MacOS, Linux, Other
  };

  private static OSType detectedOS;

  /**
   * detect the operating system from the os.name System property and cache
   * the result
   * 
   * @returns - the operating system detected
   */
  public synchronized static OSType getOSType() {
    if (detectedOS == null) {
      String osname = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
      if ((osname.indexOf("mac") >= 0) || (osname.indexOf("darwin") >= 0)) {
        detectedOS = OSType.MacOS;
      } else if (osname.indexOf("win") >= 0) {
        detectedOS = OSType.Windows;
      } else if (osname.indexOf("nux") >= 0) {
        detectedOS = OSType.Linux;
      } else {
        detectedOS = OSType.Other;
      }
    }
    return detectedOS;
  }
}
