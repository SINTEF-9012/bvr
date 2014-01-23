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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class CoveringArrayFile extends CoveringArray{
	static public enum Type {vertical, horizontal};
	
	List<List<Integer>> rows;
	
	List<Integer> weights;
	
	public int getWeight(int nr){
		if(weights.size()==0) return 0;
		return weights.get(nr);
	}
	
	public CoveringArrayFile(File file) throws IOException, CSVException{
		String csvString = "";
		
		if(file.getAbsolutePath().endsWith(".xlsx")){
			csvString = XLSXLib.getCSV(file);
		}else if(file.getAbsolutePath().endsWith(".csv")){
			csvString = new FileUtility().readFileAsString(file.getAbsolutePath());
		}else{
			throw new CSVException("Only XSLX and CSV supported: " + file.getAbsolutePath());
		}
		
		loadCaFromString(csvString);
	}
	
	public CoveringArrayFile(String csvString) throws CSVException{
		loadCaFromString(csvString);
	}
	
	private void loadCaFromString(String csvString) throws CSVException {
		// Read CSV data from file
		String csv[][];
		int x;
		int y;
		{
			csvString = csvString.replaceAll("\r", "\n");
			csvString = csvString.replaceAll("\n\n", "\n");
			
			// Load
			String rows [] = csvString.split("\n");
			x = rows[0].split(";").length;
			y = rows.length;
			//System.out.println(x + ", " + y);
			csv = new String[y][x];
			for(int j = 0; j < y; j++){
				String row = rows[j];
				String elements [] = row.split(";");
				for(int i = 0; i < x; i++){
					try{
						csv[j][i] = elements[i];
					}catch(ArrayIndexOutOfBoundsException e){
						System.err.println("CSV is required to have a equal length rows.");
						throw new CSVException();
					}
				}
			}
			
		}
		
		// Verify type
		if(!csv[0][0].equals("Feature\\Product")){
			throw new CSVException("Upper-left entry must indicate type: \"Feature\\Product\".");
		}
		
		// Transpose if vertical
		if(csv[0][0].equals("Feature\\Product")){
			csv[0][0] = "Product\\Feature";
			String transposedcsv[][] = new String[x][y];
			
			for(int j = 0; j < y; j++){
				for(int i = 0; i < x; i++){
					transposedcsv[i][j] = csv[j][i];
				}
			}
			
			int tmp = x;
			x = y;
			y = tmp;
			
			csv = transposedcsv;
		}
		
		// Read in
		{
			boolean thereAreWeights = false;
			
			int i = 0;
			nrid = new HashMap<Integer, String>();
			idnr = new HashMap<String, Integer>();
			for(String name : csv[0]){
				if(name.equals("#Weight")){
					thereAreWeights = true;
					continue;
				}
				// Skip first line
				if(i == 0){
					i++;
					continue;
				}
				nrid.put(i, name);
				idnr.put(name, i);
				//System.out.println(i + ", " + name);
				i += 1;
			}
			
			//System.out.println(nrid);
			
			rows = new ArrayList<List<Integer>>();
			weights = new ArrayList<Integer>();
			
			i = 0;
			for(String[] row : csv){
				if(i++ == 0) continue; // Skip first row
				
				List<Integer> rowlist = new ArrayList<Integer>();
				int j = 0;
				for(String e : row){
					if(j == 0){
						j++;
						continue;
					}
					if(thereAreWeights && j == 1){
						weights.add(new Integer(e));
						//System.out.println("added " + e);
						j++;
						continue; // Skip first column if weights
					}
					if(e.equals("?"))
						rowlist.add(2);
					else
						rowlist.add(e.equals("X")?0:1);
				}
				//System.out.println(rowlist);
				rows.add(rowlist);
			}
			
			//System.out.println(rows);
		}
	}

	@Override
	public void generate() throws TimeoutException {
	}

	@Override
	public Integer[] getRow(int n) {
		List<Integer> row = rows.get(n);
		Integer rowa[] = new Integer[row.size()];
		int x = 0;
		for(int i = 0; i < row.size(); i++){
			rowa[x] = row.get(x);
			x++;
		}
		return rowa;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public void setTimeout(int timeout) {
	}

	@Override
	public double estimateGenerationTime() {
		return 0;
	}

	@Override
	public String getAlgorithmName() {
		return "None";
	}

	@Override
	public void generate(int i, Integer sizelimit) throws TimeoutException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void startFrom(CoveringArray partial) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getCoverage() {
		throw new UnsupportedOperationException();
	}
}
