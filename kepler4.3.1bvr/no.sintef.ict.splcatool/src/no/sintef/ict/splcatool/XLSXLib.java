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
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXLib {

	public static String getCSV(File file) throws IOException{
		String filename = file.getAbsoluteFile().toString();
		FileInputStream fis = new FileInputStream(filename);
            
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        //System.out.println(" number of rows"+ sheet.getLastRowNum());
        String csv = "";
        int w = Integer.MAX_VALUE;
        outerloop:
        for (Row r : sheet){
        	int x = 0;
            XSSFRow row = (XSSFRow) r;
            for(Cell c : row){
                if(x >= w) break;
                XSSFCell cell = (XSSFCell) c;
                String v = "";
                if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
                	v = cell.getStringCellValue();
                }else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
                	v = ""+(int) cell.getNumericCellValue();
                }else{
                	System.out.println("Unknown type " + cell.getCellType() + " " + cell.getRawValue());
                	System.exit(-1);
                }
                //System.out.println(v + ", " + x + ", " + w);
                if(x == 0 && v.equals("#end")) break outerloop;
                if(v.equals("#end")){
                	w = x;
                	break;
                }
                csv += v + ";";
                x++;
            }
            csv += "\n";
        }
        
        //csv = csv.substring(0, csv.length()-1);
        //System.out.println(csv);
		
		return csv;
	}

}
