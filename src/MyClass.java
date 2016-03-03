import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.td.classes.Books;
 


class ReadExcelFileToList {
 
    public static List<Books> readExcelData(String fileName) {
        List<Books> countriesList = new ArrayList<Books>();
        ArrayList<String> al=new ArrayList<>();
        int cnt=0;
         
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);
             
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
             
            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();
             
            //loop through each of the sheets
            for(int i=0; i < numberOfSheets; i++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                 
                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext())
                {
                    String name = "";
                    String shortCode = "";
                     
                    //Get the row object
                    Row row = rowIterator.next();
                     
                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();
                      
                    while (cellIterator.hasNext())
                    {
                        //Get the Cell object
                        Cell cell = cellIterator.next();
                         
                        //check the cell type and process accordingly
                        switch(cell.getCellType()){
                        case Cell.CELL_TYPE_STRING:
                            if(shortCode.equalsIgnoreCase("")){
                                shortCode = cell.getStringCellValue().trim();
                            }else if(name.equalsIgnoreCase("")){
                                //2nd column
                                name = cell.getStringCellValue().trim();
                            }else{
                                //random data, leave it
                               // System.out.println("Random data::"+cell.getStringCellValue());
                            	if(cnt==0)
                            	al.add(cell.getStringCellValue());
                            }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println("Random data::"+cell.getNumericCellValue());
                        
                        }
                    } //end of cell iterator
                    /*Country c = new Country(name, shortCode);
                    countriesList.add(c);*/
                    Books b=new Books(al);
                    cnt++;
                } //end of rows iterator
                 
                 
            } //end of sheets for loop
             
            //close file input stream
            fis.close();
            System.out.println(al);
             
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return countriesList;
    }
 
    public static void main(String args[]){
        List<Books> list = readExcelData("/home/pepl-staff-001/Downloads/catalogue1.xlsx");
        System.out.println("Country List\n"+list);
    }
 
}








/*import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


class ReadExcelFile {
	
	public void readExcel() throws BiffException, IOException {
		String FilePath = "/home/pepl-staff-001/Downloads/catalogue1.xlsx";
		File f=new File(FilePath);
		/*System.out.println("Inside read mehd");
		
		if(f.exists())
		{
			System.out.println("Exists");
		}
		String mdf=FilePath.substring(0,FilePath.lastIndexOf("."));
		File f1=new File(mdf);
		if(f.renameTo(f1))
		{
			System.out.println("Renamed");
		}
		
		//System.out.println(mdf);
		
		
		Workbook wb = Workbook.getWorkbook(f);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws BiffException, IOException {
		ReadExcelFile DT = new ReadExcelFile();
		DT.readExcel();
	}
}*/