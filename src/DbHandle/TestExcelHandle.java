package DbHandle;

import Umesh.NewClass;

public class TestExcelHandle {
	public static void main(String[] args) {
		
		ExcelHandle excel = new ExcelHandle ("/home/intern4/Downloads/catalogue1.xlsx" , "Sheet1");
		System.out.println(excel.getRows());
		System.out.println(excel.getCols());
		System.out.println(excel.getRowValues("18403.0"));
		
		
		NewClass.path="/home/intern4/Downloads/catalogue1.xlsx";
		int r=NewClass.getSheet("Sheet1").getRows(); // As per my opinion these values should be fixed.
		int c=NewClass.getSheet("Sheet1").getCols();
		
		System.out.println(r + "   " + c);
	}
}
