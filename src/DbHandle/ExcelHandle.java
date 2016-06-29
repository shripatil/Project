package DbHandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {
	
	
	private XSSFSheet ExcelWSheet=null;
	private XSSFWorkbook ExcelWBook=null;
	private XSSFCell cell=null;
	private int rowtemp=0;
	private String path="";
	private boolean present=false;
	
	private String sheetName ;
	//private FileInputStream ExcelFile;
	DataFormatter dataFormatter = new DataFormatter();
	
	FileInputStream ExcelFile;
	
	public ExcelHandle (XSSFSheet ExcelWsheet) {
		this.ExcelWSheet=ExcelWsheet;
	}
	
	public ExcelHandle (String pathToExcel, String sheetname) {
		
		try {
			path = pathToExcel;
			sheetName = sheetname;
			//File fi=new File(pathToExcel);
			ExcelFile = new FileInputStream(path);
			ExcelWBook =new XSSFWorkbook(ExcelFile);
			ExcelWSheet =ExcelWBook.getSheet(sheetName);
			ExcelFile.close(); ////
			if(ExcelWSheet ==null)
			{
				System.out.println("Required Worksheet "+sheetname+" not found");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ExcelHandle getSheet (String sheetname) {
		
		ExcelWSheet =ExcelWBook.getSheet(sheetname);
		
		if(ExcelWSheet ==null)
		{
			System.out.println("Required Worksheet "+sheetname+" not found");
		}
		return this;
	}
	
	public int getRows()
	{
		if(ExcelWSheet!=null)
		{
			int temp=ExcelWSheet.getLastRowNum()+1;
			return temp;
			
		}
		else
		{
			System.out.println("Rows cannot found");
			return 0;
		}
	}
	
	public int getCols()
	{
		if(ExcelWSheet!=null)
		{
			int temp=ExcelWSheet.getRow(0).getLastCellNum();
			return temp;
		}
		else
		{
			System.out.println("cols cannot found");
			return 0;
		}
	}
	
	public ExcelHandle setCurrentRow(int rownumber)
	{
		rowtemp=rownumber;
		return this;
	}
	
	public String getCellData(int columnname) throws Exception {
		try
		{
			cell=ExcelWSheet.getRow(rowtemp).getCell(columnname);
			
			// Added newly by Umesh
			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			   return null;
			 }

			return cellToString (cell);
		} catch(Exception e) {
			System.out.println("Excel out of bound");
			throw new Exception ();
			//return "";  // As per my opinion this should return null
		}
	}
	
	
	public String getCellData(int rowNumber , int columnname) throws Exception {
		try
		{
			cell=ExcelWSheet.getRow(rowNumber).getCell(columnname);
			
			// Added newly by Umesh
			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			   return null;
			 }

			return cellToString (cell);
		} catch(Exception e) {
			
			//System.out.println("Excel out of bound");
			throw new Exception ();
			//return "";  // As per my opinion this should return null
		}
	}
	
	
	private String cellToString(XSSFCell cell)
	{
		int type=cell.getCellType();
		Object value;
		switch(type)
		{
		case 0:
			//value=cell.getNumericCellValue();
			String value1 = dataFormatter.formatCellValue(cell);
	        //if (! value1.trim().isEmpty()) {
	         //   System.out.println("Cell as string is " + value1);
	        //}
			return value1;
			//break;
		case 1:
			value=cell.getStringCellValue();
			break;
		default: 
			System.out.println("Type is not recognized");
			value= null;
		}

		return value.toString();
	}
	
	public void setCellData (String value,int rowNo,int columnName)
	{

		XSSFRow row = ExcelWSheet.getRow(rowNo);
		
		XSSFCell cell = row.getCell(columnName);
		if (cell == null)
		    cell = row.createCell(columnName);
		else {
			System.out.println("cell is not null : " + cellToString(cell));
			
		}
		
		//cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
		
		saveExcelFile();
		
	}
	
	private void saveExcelFile () {
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
			ExcelWSheet.getWorkbook().write(fos);
			//book1.write(fos);
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// specific to this class
	
	public ArrayList <String> getRowValues (String rowID) {
		
		ArrayList <String> rowValues = new ArrayList <String>();
		
		int noOfRows = getRows();
		
		for (int r=0; r<noOfRows; r++) {
			try {
				//String data = getCellData(i, 0);
				//System.out.println(getCellData(r, 0) + " this is first colmn");
				int cols1 = getCols();
				if (rowID.equals(getCellData(r, 0))) {
					
					rowValues.add(Integer.toString(r));
					for (int c=0; c<cols1; c++) {
						rowValues.add(getCellData(r, c));
						//System.out.println("row value " + getCellData(r, c));
					}
				}

			} catch (Exception e) {
				//e.printStackTrace();
				break;
			}
			
		}
		
		return rowValues;
	}
	
	public ArrayList <String> getRowValues (int rowNumber) {
		
		ArrayList <String> rowValues = new ArrayList <String>();
		
		rowValues.add(Integer.toString(rowNumber));
		
		int cols1 = getCols();
		System.out.println(cols1 + " cols");
		for (int c=0; c<cols1; c++) {
			try {
				rowValues.add(getCellData(rowNumber, c));
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}

		}
		
		return rowValues;
	}
	
	
	public boolean setRowValues ( ArrayList <String> rowValues) {
		
		int rowNumber = Integer.parseInt(rowValues.get(0));
		
		XSSFRow row = ExcelWSheet.getRow(rowNumber);
		
		
		for ( int c=0; c < rowValues.size()-1; c++) {
			
			XSSFCell cell = row.getCell(c);
			if (cell == null)
			    cell = row.createCell(c);
			else {
				//System.out.println("cell is not null : " + cellToString(cell));
				
			}
			
			//cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(rowValues.get(c+1));
			
		}

		//////////////////////////////
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
			ExcelWSheet.getWorkbook().write(fos);
			//book1.write(fos);
			fos.flush();
		//	fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 // Reload the workbook, workaround for bug 49940
	    // https://issues.apache.org/bugzilla/show_bug.cgi?id=49940
//		try {
//			ExcelFile = null;
//			ExcelWBook = null;
//			ExcelWSheet = null;
//			ExcelFile = new FileInputStream(path);
//			ExcelWBook =new XSSFWorkbook(ExcelFile);
//			ExcelWSheet =ExcelWBook.getSheet(sheetName);
//			ExcelFile.close(); ////
//		} catch (Exception e) {
//			
//		}
		
		return true;
	}
	
	
	public class Read {
		 public static final String LIBRARYFILE = "Sheet1";
		 public static final String RULESFILE = "Sheet4";
		 public static final String HISTORYFILE = "Sheet5";
		 public static final String STUDENTDATA = "Sheet2";
		 public static final String TEACHERDATA = "Sheet3";
	 }

}
