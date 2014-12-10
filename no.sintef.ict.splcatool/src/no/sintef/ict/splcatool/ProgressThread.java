/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import java.util.List;

public class ProgressThread implements Runnable{

	private List<ProgressReporter> prs;
	private long goal;
	private String name;
	
	private boolean report = true;

	public ProgressThread(String name, List<ProgressReporter> prs, long goal) {
		this.name = name;
		this.prs = prs;
		this.goal = goal;
	}

	@Override
	public void run() {
		while(report){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if(!report) break;
			long progress = 0;
			for(int i = 0; i < prs.size(); i++){
				progress += prs.get(i).getProgress();
			}
			System.out.println(name + " progress: " + progress + "/" + goal + " = " + progress*100/goal + "%");
		}
	}

	public void stop() {
		report = false;
	}
}
