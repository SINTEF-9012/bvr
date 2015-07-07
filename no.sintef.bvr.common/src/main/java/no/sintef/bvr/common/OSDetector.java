/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
