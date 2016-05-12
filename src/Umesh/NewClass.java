package Umesh;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.invoke.ConstantCallSite;

import org.apache.poi.hpsf.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class NewClass {
	public XSSFSheet ExcelWsheet=null;
	public XSSFWorkbook ExcelWBook=null;
	public static XSSFWorkbook WriteExcelWBook=null;
	public static XSSFSheet WriteExcelWsheet=null;
	public static XSSFCell cell=null;
	public static XSSFRow row=null;
	public static int rowtemp=0;
	public static String path="";
	public static String neewexcelpath="";
	public static boolean present=false;
	
	public NewClass(XSSFSheet ExcelWsheet) {
		this.ExcelWsheet=ExcelWsheet;
	}
	
	public NewClass() {
		ExcelWsheet=null; ///////////////////////////////////////
	}
	
	public int getRows()
	{
		if(ExcelWsheet!=null)
		{
			int temp=ExcelWsheet.getLastRowNum()+1;
			ExcelWsheet=null;
			ExcelWBook=null;
			return temp;
			
		}
		else
		{
			System.out.println("Rows cannot found");
			ExcelWsheet=null; ////////////////////////////////
			ExcelWBook=null;
			return 0;
		}
	}
	
	public int getCols()
	{
		if(ExcelWsheet!=null)
		{
			int temp=ExcelWsheet.getRow(0).getLastCellNum();
			ExcelWsheet=null;
			ExcelWBook=null;
			return temp;
		}
		else
		{
			System.out.println("cols cannot found");
			ExcelWsheet=null; /////////////////////////////////
			ExcelWBook=null;
			return 0;
		}
	}
	
	public String getCellData(int columnname)
	{
		try
		{
			cell=ExcelWsheet.getRow(rowtemp).getCell(columnname);
			
			// Added newly by Umesh
			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			   return null;
			 }
			
		//	if (!cell.getBooleanCellValue()) {
		//		return "anothernull";
		//	}
			return cellToString (cell);
		} catch(Exception e)
		{
			System.out.println("Excel out of bound");
			return "";  // As per my opinion this should return null
		}
	}
	
	
	
	////////////// static 
	
	
	public static NewClass getSheet(String sheetname) {
		try
		{
			File fi=new File(path);
			FileInputStream ExcelFile=new FileInputStream(fi);
			XSSFWorkbook ExcelWBook1=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelWSheet1=ExcelWBook1.getSheet(sheetname);
			if(ExcelWSheet1!=null)
			{
				NewClass n=new NewClass(ExcelWSheet1);
				return n;
			}
			else
			{
				System.out.println("Required Worksheet "+sheetname+"not found");
				NewClass nn=new NewClass();
				return nn;
			}
			
		} catch(Exception e)
		{
			System.out.println("Required Worksheet "+sheetname+"not found");
			NewClass nn=new NewClass();
			return nn;
		}
	}
	
	public static void setCurrentRow(int rownumber)
	{
		rowtemp=rownumber;
	}
	
	// by U2I this following method is not yet confirm.
	static void setCellToThisDom(String value,int rowNo,int columnName)
	{
		row=WriteExcelWsheet.getRow(rowNo);
		cell=row.createCell(columnName);
		cell.setCellValue(value);
		saveTempExcel(WriteExcelWBook);
		WriteExcelWsheet=null;
		WriteExcelWBook=null;
		row=null;
		cell=null;
		
	}
	
	private static void saveTempExcel(XSSFWorkbook book1) {
		try{
			if(!neewexcelpath.isEmpty())
			{
				FileOutputStream fos=new FileOutputStream(neewexcelpath);
				book1.write(fos);
				fos.flush();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	static void createExcelworksheetSheets(int number,int CreationSheetRow,String[] names)
	{
		if(!present)
		{
			XSSFWorkbook writeExcelBook1=new XSSFWorkbook();
			for(int j=0;j<number;j++)
			{
				XSSFSheet WriteExcelSheet1=writeExcelBook1.createSheet(names[j]);
				for (int i = 0; i <=CreationSheetRow; i++) {
					WriteExcelSheet1.createRow(i);
				}
			}
			saveTempExcel(writeExcelBook1);
			present=true;
		}
	}
	static void setCellData(String sheetname,String value,int columnname )
	{
		try
		{
			if(!neewexcelpath.isEmpty())
			{
				File fi=new File(neewexcelpath);
				FileInputStream ExcelFile= new FileInputStream(fi);
				WriteExcelWBook =new XSSFWorkbook(ExcelFile);
				WriteExcelWsheet=WriteExcelWBook.getSheet(sheetname);
				
				row=WriteExcelWsheet.getRow(rowtemp);
				cell=row.createCell(columnname);
				cell.setCellValue(value);
				saveTempExcel(WriteExcelWBook);
				WriteExcelWBook=null;
				WriteExcelWsheet=null;
				row=null;
				cell=null;
				
			}
			else
			{
				System.out.println("plz provide path");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String cellToString(XSSFCell cell)
	{
		int type=cell.getCellType();
		Object value;
		switch(type)
		{
		case 0:
			value=cell.getNumericCellValue();
			break;
		case 1:
			value=cell.getStringCellValue();
			break;
		default: 
			System.out.println("Type is not recognized");
			value= null;
		}

		return value.toString();
	}
}
