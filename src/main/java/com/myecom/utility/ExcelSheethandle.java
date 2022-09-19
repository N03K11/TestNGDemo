package com.myecom.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.myecom.base.BaseClass;

public class ExcelSheethandle extends BaseClass
{
	public static FileInputStream fis;
	
	public static FileInputStream getExcelFile() throws FileNotFoundException 
	{
		fis = new FileInputStream(projectPath+"//src//test//resources//testdata//Frameworkdemo.xlsx");
		return fis;
	}

	public Sheet getSheet(FileInputStream filename, String sheetname) throws EncryptedDocumentException, IOException 
	{
		Sheet sh = WorkbookFactory.create(filename).getSheet(sheetname);
		return sh;
	}
	
	public HashMap<String, Object> getExcelSheetData(Sheet sh) 
	{
		int getRow = sh.getLastRowNum();
		
		HashMap<String, Object> data = new HashMap();
		
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
		
			int column = sh.getRow(i).getLastCellNum();
			for(int j=0; j<column; j++) 
			{
				if(sh.getRow(i+1).getCell(j).getCellType().name().equals("STRING")) //.name() is given to convert Enum cell to String cell
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue(), 
							sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				
				
				else if (sh.getRow(i+1).getCell(j).getCellType().name().equals("NUMERIC")) 
				{
					String num = String.valueOf((long)sh.getRow(i+1).getCell(j).getNumericCellValue());
					
					data.put(sh.getRow(0).getCell(j).getStringCellValue(), num);
					
				}
				
			}
		}
		
		return data;
	}
	
	public String getSingleCellValue(Sheet sh, int row, int column) 
	{
		String value = sh.getRow(row).getCell(column).getStringCellValue();
		return value;
	}
	
	/*public HashMap<String, Object> getExcelSheetData1(Sheet sh) 
	{
		HashMap<String, Object> data = new HashMap();
		
		for(int i=0; i<=sh.getLastRowNum(); i++) 
		{ //row
			int cellCount = sh.getRow(i).getLastCellNum();
			
			for(int j=0; j<cellCount; j++) 
			{ //column
				CellType ct = sh.getRow(i+1).getCell(j).getCellType();
				switch(ct){
					case STRING:
						data.put(sh.getRow(0).getCell(j).getStringCellValue(), 
								sh.getRow(i+1).getCell(j).getStringCellValue());
						break;
						
					case NUMERIC:
						
						String sValue = String.valueOf((int)sh.getRow(i+1).getCell(j).getNumericCellValue());
						data.put(sh.getRow(0).getCell(j).getStringCellValue(), sValue);
						break;
				}
			}
		} 
		return data;
	}*/

}
