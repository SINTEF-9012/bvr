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

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestCmdLineInteraction2 {
	
	@Test
	public void test_t_wise_weighted_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted"
			}
		);
	}
	
	@Test
	public void test_t_wise_weighted_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void test_t_wise_weighted_err3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "2", 
			}
		);
	}
	@Test
	public void test_t_wise_weighted_non_existing1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/car_fm.xmlXXX").getAbsoluteFile().toString(),
			"-s", "2", 
			}
		);
	}
	@Test
	public void test_t_wise_weighted_non_existing2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/car_fm.xmlXXX").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Realistic/blabla").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_empty_1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Artificial/buggy/empty/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Artificial/buggy/empty/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_empty_2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/Tomra/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Artificial/buggy/empty/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_empty_3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Artificial/buggy/empty/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Realistic/Tomra/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_empty_4() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/Tomra/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Realistic/Tomra/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			"-startFrom", new File("TestData/Artificial/buggy/empty/rvm.m.actual.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_faulty_1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Artificial/buggy/faulty/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Artificial/buggy/empty/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_faulty_2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/Tomra/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Artificial/buggy/faulty/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_faulty_3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Artificial/buggy/faulty/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Realistic/Tomra/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			}
		);
	}
	@Test
	public void test_t_wise_weighted_faulty_4() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException{
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/Tomra/rvm-no-software.m").getAbsoluteFile().toString(),
			"-s", "2",
			"-weights", new File("TestData/Realistic/Tomra/rvm.m.actual-weighted.csv").getAbsoluteFile().toString(),
			"-startFrom", new File("TestData/Artificial/buggy/faulty/rvm.m.actual.csv").getAbsoluteFile().toString(),
			}
		);
	}
}
