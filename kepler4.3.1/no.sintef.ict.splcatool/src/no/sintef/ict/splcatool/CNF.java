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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;

public class CNF {
	public enum type {dimacs, dot, cnf}

	@Override
	public boolean equals(Object _cnfb) {
		CNF cnfb = (CNF) _cnfb;
		CNF cnfa = this;
	
		System.out.println(cnfa.cnf.getVariables().size());
		System.out.println(cnfb.cnf.getVariables().size());

		if(!cnfa.cnf.getVariables().containsAll(cnfb.cnf.getVariables())){
			return false;
		}

/*		if(!cnfb.cnf.getLiterals().containsAll(cnfa.cnf.getLiterals())){
			return false;
		}
*/		
		return true;
	}

	private CNFFormula cnf;
	 Map<String, Integer> idnr = new HashMap<String, Integer>();
	private Map<Integer, String> nrid = new HashMap<Integer, String>();
	private File fmdir;
	
	public Integer getNr(String id){
		return idnr.get(id);
	}
	
	public String getID(Integer nr){
		return nrid.get(nr);
	}
	
	public Set<BooleanVariableInterface> getVariables(){
		return cnf.getVariables();
	}
	
	public Set<CNFClause> getClauses(){
		return cnf.getClauses();
	}
	
	public CNF(String fmfile){
		this.fmdir = new File(fmfile + "-cache");
		if(!fmdir.exists()){
			fmdir.mkdir();
		}else{ // If the feature model has changed, start from a fresh cache
			String fmfilecontents1 = "";
			String fmfilecontents2 = "";
			try {
				fmfilecontents1 = new FileUtility().readFileAsString(fmfile);
				fmfilecontents2 = new FileUtility().readFileAsString(fmdir.getPath()+"/"+new File(fmfile).getName());
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
			
			if(!fmfilecontents1.equals(fmfilecontents2)){
				for(File f : fmdir.listFiles()){
					f.delete();
				}
				fmdir.delete();
				fmdir.mkdir();
			}
		}
		
		// Copy feature model into cache for datedness checks
		try {
			String fmfilecontents = new FileUtility().readFileAsString(fmfile);
			new FileUtility().writeStringToFile(
				fmdir.getPath()+"/"+new File(fmfile).getName(), 
				fmfilecontents
			);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public CNF(CNFFormula cnf, String fmfile) {
		if(fmfile != null)
			this.fmdir = new File(new File(fmfile).getParent());
		this.cnf = cnf;
		
		// Init id-number mappings
		int i = 1;
		for(BooleanVariableInterface v : cnf.getVariables()){
			nrid.put(new Integer(i), v.getID());
			idnr.put(v.getID(), new Integer(i));
			//System.out.println(new Integer(i) + ":" + v.getID());
			i++;
		}
	}
	
	public CNF(String fmfile, type t) throws IOException{
		this(fmfile);
		if(t == type.dimacs){
			loadDimacs(fmfile);
		}else if(t == type.dot){
			loadDot(fmfile);
		}else if(t == type.cnf){
			loadCnf(fmfile);
		}
	}
	
	private void loadCnf(String file) throws IOException {
		//Map<Integer, String> nrid = new HashMap<Integer, String>();
		Set<Set<Integer>> cs = new HashSet<Set<Integer>>();
		
		String filec = new FileUtility().readFileAsString(file);
		
		int j = 0;
		int c_count = 0;
		int nc_count = 0;
		int p_count = 0;
		int given_p = 0;
		int given_c = 0;
		for(String line : filec.split("\n")){
			line = line.trim();
			if(line.startsWith("c") && line.split(" ").length==2){
				//System.out.println(line);
				String nr = line.split(" ")[1].replace("$", "").split("->")[0];
				String id = line.split("->")[1];
				nrid.put(new Integer(nr), id);
				idnr.put(id, new Integer(nr));
				p_count++;
			}else if(line.endsWith(" 0")){
				Set<Integer> c = new HashSet<Integer>();
				line = line.substring(0, line.length()-1).trim(); // Remove end 0
				for(String p : line.split(" ")){
					c.add(new Integer(p));
				}
				int oldsize = cs.size();
				cs.add(c);
				if(oldsize == cs.size()){
					nc_count++;
					/*System.out.println("Duplicate line: " + line);
					List<Set<Integer>> nns = new ArrayList<Set<Integer>>(cs);
					for(int i = 0; i < nns.size(); i++){
						if(nns.get(i).equals(c)){
							System.out.println(nns.get(i));
						}
					}
					System.exit(0);*/
				}else{
					c_count++;
				}
				j++;
			}else if(line.startsWith("p cnf")){
				given_p = new Integer(line.split(" ")[2]);
				given_c = new Integer(line.split(" ")[3]);
			}else{
				if(!line.trim().equals(""))
					throw new IOException("Error loading file due to: " + line);
			}
		}
		
		if(given_p != p_count || (c_count + nc_count) != given_c){
			System.out.println("Given p and c not equal with actual p and c: " + given_p + " and " + given_c + " vs " + p_count + " and " + (c_count + nc_count));
			System.exit(-1);
		}
		
		System.out.println("CNF: Given p and c: " + given_p + " and " + given_c);
		/*
		System.out.println("Features: " + p_count);
		System.out.println("Constraints: " + c_count);
		System.out.println("All constraints: " + (c_count + nc_count));
		*/
		
		// Write CNF
		Map<String, BooleanVariableInterface> vars = new HashMap<String, BooleanVariableInterface>();
		CNFFormula cnf = new CNFFormula();
		for(Set<Integer> clause : cs){
			CNFClause cl = new CNFClause();
			
			//System.out.println("Clause: " + clause);
		
			for(Integer p : clause){
				boolean isNegative = (p<0);
				BooleanVariableInterface bv = null;
				if(vars.get(nrid.get(Math.abs(p))) == null){
					//System.out.println(nrid.get(Math.abs(p)));
					bv = new BooleanVariable(nrid.get(Math.abs(p)));
					vars.put(nrid.get(Math.abs(p)), bv);
				}else{
					bv = vars.get(nrid.get(Math.abs(p)));
				}
				CNFLiteral l = new CNFLiteral(bv, !isNegative);
				cl.addLiteral(l);
			}
			cnf.addClause(cl);
		}
		
		this.cnf = cnf;
	}

	private void loadDimacs(String dimacsFile) throws IOException{
		Set<Set<Integer>> cs = new HashSet<Set<Integer>>();
		
		String filec = new FileUtility().readFileAsString(dimacsFile);
		
		int j = 0;
		int c_count = 0;
		int nc_count = 0;
		int p_count = 0;
		int given_p = 0;
		int given_c = 0;
		for(String line : filec.split("\n")){
			line = line.trim();
			if(line.startsWith("c") && line.split(" ").length==3){
				//System.out.println(line);
				String nr = line.split(" ")[1].replace("$", "");
				String id = line.split(" ")[2];
				nrid.put(new Integer(nr), id);
				idnr.put(id, new Integer(nr));
				p_count++;
			}else if(line.endsWith(" 0")){
				Set<Integer> c = new HashSet<Integer>();
				line = line.substring(0, line.length()-1).trim(); // Remove end 0
				for(String p : line.split(" ")){
					c.add(new Integer(p));
				}
				int oldsize = cs.size();
				cs.add(c);
				if(oldsize == cs.size()){
					nc_count++;
					/*System.out.println("Duplicate line: " + line);
					List<Set<Integer>> nns = new ArrayList<Set<Integer>>(cs);
					for(int i = 0; i < nns.size(); i++){
						if(nns.get(i).equals(c)){
							System.out.println(nns.get(i));
						}
					}
					System.exit(0);*/
				}else{
					c_count++;
				}
				j++;
			}else if(line.startsWith("p cnf")){
				given_p = new Integer(line.split(" ")[2]);
				given_c = new Integer(line.split(" ")[3]);
			}else{
				throw new IOException("Error loading file due to: " + line);
			}
		}
		
		if(given_p != p_count || (c_count + nc_count) != given_c){
			System.out.println("Given p and c not equal with actual p and c: " + given_p + " and " + given_c + " vs " + p_count + " and " + (c_count + nc_count));
			System.exit(-1);
		}
		
		System.out.println("CNF: Given p and c: " + given_p + " and " + given_c);
		/*
		System.out.println("Features: " + p_count);
		System.out.println("Constraints: " + c_count);
		System.out.println("All constraints: " + (c_count + nc_count));
		*/
		
		// Write CNF
		Map<String, BooleanVariableInterface> vars = new HashMap<String, BooleanVariableInterface>();
		Set<String> stored = new HashSet<String>();
		CNFFormula cnf = new CNFFormula();
		for(Set<Integer> clause : cs){
			CNFClause cl = new CNFClause();
			
			//System.out.println("Clause: " + clause);
		
			for(Integer p : clause){
				boolean isNegative = (p<0);
				BooleanVariableInterface bv = null;
				if(vars.get(nrid.get(Math.abs(p))) == null){
					//System.out.println(nrid.get(Math.abs(p)));
					bv = new BooleanVariable(nrid.get(Math.abs(p)));
					vars.put(nrid.get(Math.abs(p)), bv);
				}else{
					bv = vars.get(nrid.get(Math.abs(p)));
				}
				stored.add(bv.getID());
				CNFLiteral l = new CNFLiteral(bv, !isNegative);
				cl.addLiteral(l);
			}
			cnf.addClause(cl);
		}
		
		// Add the remaining vars
/*		System.out.println(stored.size());
		System.out.println(nrid.values().size());
*/		for(String x : nrid.values()){
			if(!stored.contains(x)){
				BooleanVariableInterface bv = new BooleanVariable(x);
				vars.put(x, bv);
				CNFClause cl = new CNFClause();
				CNFLiteral l1 = new CNFLiteral(bv, true);
				CNFLiteral l2 = new CNFLiteral(bv, true);
				cl.addLiteral(l1);
				cl.addLiteral(l2);
				cnf.addClause(cl);
			}
		}
		
		this.cnf = cnf;
	}
	
	private void loadDot(String dotFile) throws IOException{
		Map<Integer, String> nrid = new HashMap<Integer, String>();
		Set<Set<Integer>> cs = new HashSet<Set<Integer>>();
		
		String filec = new FileUtility().readFileAsString(dotFile);
		
		for(String line : filec.split("\n")){
			line = line.trim();
			if(line.contains(" [label = ")){
				//System.out.println(line);
				String nr = line.split(" ")[0];
				String id = line.substring(("  "+nr+" [label = \"").length(), line.length()-3);
				nrid.put(new Integer(nr), id);
				idnr.put(id, new Integer(nr));
			}else if(line.contains("->")){
				Set<Integer> c = new HashSet<Integer>();
				line = line.substring(0, line.length()-1).trim(); // Remove end ;
				for(String p : line.split(" -> ")){
					c.add(new Integer(p));
				}
				cs.add(c);
			}
		}
		
		//System.out.println("Features: " + nrid.size());
		//System.out.println("Constraints: " + cs.size());
		
		// Write CNF
		Map<String, BooleanVariableInterface> vars = new HashMap<String, BooleanVariableInterface>();
		CNFFormula cnf = new CNFFormula();
		for(Set<Integer> clause : cs){
			CNFClause cl = new CNFClause();
			
			//System.out.println("Clause: " + clause);
		
			boolean isNegative = true; // first is true, second is false
			for(Integer p : clause){
				BooleanVariableInterface bv = null;
				if(vars.get(nrid.get(Math.abs(p))) == null){
					bv = new BooleanVariable(nrid.get(p));
					vars.put(nrid.get(p), bv);
				}else{
					bv = vars.get(nrid.get(p));
				}
				CNFLiteral l = new CNFLiteral(bv, !isNegative);
				cl.addLiteral(l);
				isNegative = false;
			}
			cnf.addClause(cl);
		}
		
		this.cnf = cnf;
	}

	public SAT4JSolver getSAT4JSolver() throws ContradictionException {
		// Load into SAT4J
		final int MAXVAR = cnf.countVariables();
		final int NBCLAUSES = cnf.countClauses();
		ISolver solver = SolverFactory.newDefault();
		solver.setDBSimplificationAllowed(true);
		solver.newVar(MAXVAR);
		solver.setExpectedNumberOfClauses(NBCLAUSES);
/*		int i = 1;
		synchronized(this){
		for(BooleanVariableInterface v : cnf.getVariables()){
			idnr.put(v.getID(), i);
			nrid.put(i, v.getID());
			i++;
		}
		}
*/		
		for(CNFClause c : cnf.getClauses()){
			//System.out.println("clause " + x++ + " of " + cnf.getClauses().size());
			
			List<Integer> li = new ArrayList<Integer>();
			for(CNFLiteral l : c.getLiterals()){
				//System.out.println(idnr.get(l.getVariable().getID()));
				if(l.isPositive()){
					li.add(idnr.get(l.getVariable().getID()));
				}else{
					li.add(-idnr.get(l.getVariable().getID()));
				}
			}
			int [] clause = new int [li.size()];
			for(int j=0;j<li.size();j++)
				clause[j] = li.get(j);

			try{
				solver.addClause((IVecInt) new VecInt(clause));
			}catch(ContradictionException ce){
				System.out.println("empty clause:" + c);
				System.out.println("empty clause:" + clause.length);
			}
			
/*			try {
				if(!solver.isSatisfiable()){
					return null;
				}
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/		}
		
		return new SAT4JSolver((ISolver)solver);
	}
	
	public SAT4JSolver getSAT4JSolverInverse() throws ContradictionException {
		// Load into SAT4J
		final int MAXVAR = cnf.countVariables();
		final int NBCLAUSES = cnf.countClauses();
		ISolver solver = SolverFactory.newDefault();
		solver.setDBSimplificationAllowed(true);
		solver.newVar(MAXVAR);
		solver.setExpectedNumberOfClauses(NBCLAUSES);
/*		int i = 1;
		synchronized(this){
		for(BooleanVariableInterface v : cnf.getVariables()){
			idnr.put(v.getID(), i);
			nrid.put(i, v.getID());
			i++;
		}
		}
*/		
		for(CNFClause c : cnf.getClauses()){
			//System.out.println("clause " + x++ + " of " + cnf.getClauses().size());
			
			List<Integer> li = new ArrayList<Integer>();
			for(CNFLiteral l : c.getLiterals()){
				//System.out.println(idnr.get(l.getVariable().getID()));
				if(l.isPositive()){
					li.add(-idnr.get(l.getVariable().getID()));
				}else{
					li.add(idnr.get(l.getVariable().getID()));
				}
			}
			int [] clause = new int [li.size()];
			for(int j=0;j<li.size();j++)
				clause[j] = li.get(j);

			try{
				solver.addClause((IVecInt) new VecInt(clause));
			}catch(ContradictionException ce){
				System.out.println("empty clause:" + c);
				System.out.println("empty clause:" + clause.length);
			}
			
/*			try {
				if(!solver.isSatisfiable()){
					return null;
				}
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/		}
		
		return new SAT4JSolver((ISolver)solver);
	}

	private CoveringArray getCoveringArrayGeneratorJ11(int t, int threads) {
		return new CoveringArrayAlgJ11(t, this, nrid, idnr, threads);
	}
	
	private CoveringArray getCoveringArrayGeneratorJ11Utils(int t, int threads) {
		return new CoveringArrayAlgJ11Utils(t, this, nrid, idnr, threads);
	}
	
	private CoveringArray getCoveringArrayGeneratorJ12(int t, int threads) {
		return new CoveringArrayAlgJ12(t, this, nrid, idnr, threads);
	}
	
	private CoveringArray getCoveringArrayGeneratorChvatal(int t, int threads) {
		return new CoveringArrayChvatal(t, this, nrid, idnr, threads);
	}
	
	private CoveringArray getCoveringArrayGeneratorChvatalWeighted(int t, int threads, String weightfile) {
		return new CoveringArrayChvatalWeighted(t, this, nrid, idnr, threads, weightfile);
	}
	
	@Override
	public String toString() {
		return cnf.toString();
	}

	public CoveringArray getCoveringArrayGenerator(String a, int t, int threads) {
		if(a.equals("J11")){
			if(t==1 || t==2 || t==3) return getCoveringArrayGeneratorJ11(t, threads);
			else return null;
		}else if(a.equals("J12")){
			if(t==1 || t==2 || t==3) return getCoveringArrayGeneratorJ12(t, threads);
			else return null;
		}else if(a.equals("J11Utils")){
			if(t==1 || t==2 || t==3) return getCoveringArrayGeneratorJ11Utils(t, threads);
			else return null;
		}else if(a.equals("Chvatal")){
			if(t==1 || t==2 || t==3 || t==4) return getCoveringArrayGeneratorChvatal(t, threads);
			else return null;
		}else{
			return null;
		}
	}
	
	public CoveringArray getCoveringArrayGenerator(String a, int t, int threads, String weightfile) {
		if(a.equals("ChvatalWeighted")){
			if(t==1 || t==2 || t==3)
				return getCoveringArrayGeneratorChvatalWeighted(t, threads, weightfile);
			else
				return null;
		}else{
			return null;
		}
	}

	public void writeToFile(String filename) throws FileNotFoundException, IOException{
		StringBuffer sb = new StringBuffer();
		for(BooleanVariableInterface v : cnf.getVariables()){
			sb.append("c " + getNr(v.getID()) + " " + v.getID() + "\n");
		}
		sb.append("p cnf " + cnf.getVariables().size() + " " + cnf.getClauses().size() + "\n");
		for(CNFClause c : cnf.getClauses()){
			for(CNFLiteral l : c.getLiterals())
				sb.append((l.isPositive()?1:-1) * getNr(l.getVariable().getID()) + " ");
			sb.append("0\n");
		}
		new FileUtility().writeStringToFile(filename, sb.toString());
	}

	// Invalid tuples sets
	private Set<Pair> invalid1w;
	private Set<Pair2> invalid2w;
	private Set<Pair3> invalid3w;
	//Set<Pair4> invalid4w;
	
	public Set<Pair> generateInvalid1(){
		if(invalid1w != null) return invalid1w;
		
		// Generate
		CoveringArrayAlgJ11Utils ca = (CoveringArrayAlgJ11Utils)getCoveringArrayGenerator("J11Utils", 1, Runtime.getRuntime().availableProcessors());
		try{
			ca.generate();
		}catch(TimeoutException e){}
		Set<Pair> invalid1w = new HashSet<Pair>(ca.invalid1w);
		
		// Make unmodifiable
		this.invalid1w = Collections.unmodifiableSet(invalid1w);
		return invalid1w;
	}

	public Set<Pair2> generateInvalid2(){
		if(invalid2w != null) return invalid2w;
		
		generateInvalid1();
		
		// Generate
		CoveringArrayAlgJ11Utils ca = (CoveringArrayAlgJ11Utils)getCoveringArrayGenerator("J11Utils", 2, Runtime.getRuntime().availableProcessors());
		ca.invalid1w = invalid1w;
		try {
			ca.generate();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		Set<Pair2> invalid2w = new HashSet<Pair2>(ca.invalid2w);
		
		// Make unmodifiable
		this.invalid2w = Collections.unmodifiableSet(invalid2w);
		return invalid2w;
	}

	public Set<Pair3> generateInvalid3() {
		if(invalid3w != null) return invalid3w;
		
		generateInvalid2();
		
		// Generate
		CoveringArrayAlgJ11Utils ca = (CoveringArrayAlgJ11Utils)getCoveringArrayGenerator("J11Utils", 3, Runtime.getRuntime().availableProcessors());
		ca.invalid1w = invalid1w;
		ca.invalid2w = invalid2w;
		ca.fmdir = fmdir;
		try {
			ca.generate();
		} catch (TimeoutException e) {
		}
		Set<Pair3> invalid3w = new HashSet<Pair3>(ca.invalid3w);
		
		// Make unmodifiable
		this.invalid3w = Collections.unmodifiableSet(invalid3w);
		return invalid3w;
	}
	
	private List<Pair> u1;
	private List<Pair2> u2;
	private List<Pair3> u3;
	
	public List<Pair> getU1() {
		if(u1 != null) return u1;
		
		generateInvalid1();
		
		u1 = new ArrayList<Pair>();
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(getVariables());
		for(BooleanVariableInterface v : vars){
			for(boolean b : new boolean [] {false, true}){
				Pair p = new Pair(v, b);
				if(!invalid1w.contains(p)){
					u1.add(p);
				}
			}
		}
		
		// Make unmodifiable
		u1 = Collections.unmodifiableList(u1);
		return u1;
	}

	public List<Pair2> getU2() {
		if(u2 != null) return u2;
		
		generateInvalid2();
		
		u2 = new ArrayList<Pair2>();
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(getVariables());
		for(int i = 0; i < vars.size(); i++){
			BooleanVariableInterface v1 = vars.get(i);
			for(int j = i+1; j < vars.size(); j++){
				BooleanVariableInterface v2 = vars.get(j);
				for(boolean b1 : new boolean [] {false, true}){
					for(boolean b2 : new boolean [] {false, true}){
						// Set pair
						Pair2 unc;
						unc = new Pair2(idnr);
						unc.v1 = v1;
						unc.b1 = b1;
						unc.v2 = v2;
						unc.b2 = b2;
						if(!invalid2w.contains(unc)){
							u2.add(unc);
						}
					}
				}
			}
		}
		
		// Make unmodifiable
		u2 = Collections.unmodifiableList(u2);
		return u2;
	}
	
	public List<Pair3> getU3(){
		if(u3 != null) return u3;
		
		generateInvalid3();
		
		u3 = new ArrayList<Pair3>();
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(getVariables());
		for(int i = 0; i < vars.size(); i++){
			BooleanVariableInterface v1 = vars.get(i);
			for(int j = i+1; j < vars.size(); j++){
				BooleanVariableInterface v2 = vars.get(j);
				for(int k = j+1; k < vars.size(); k++){
					BooleanVariableInterface v3 = vars.get(k);
					for(boolean b1 : new boolean [] {false, true}){
						for(boolean b2 : new boolean [] {false, true}){
							for(boolean b3 : new boolean [] {false, true}){
								// Set pair
								Pair3 unc;
								unc = new Pair3(idnr);
								unc.v1 = v1;
								unc.b1 = b1;
								unc.v2 = v2;
								unc.b2 = b2;
								unc.v3 = v3;
								unc.b3 = b3;
								if(!invalid3w.contains(unc)){
									u3.add(unc);
								}
							}
						}
					}
				}
			}
		}
		
		// Make unmodifiable
		u3 = Collections.unmodifiableList(u3);
		return u3;
	}
}
