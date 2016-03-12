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
	static int cnt=0;
	  static Books b[]=new Books[100];
    public static List<Books> readExcelData(String fileName) {
        List<Books> countriesList = new ArrayList<Books>();
        ArrayList<String> al=new ArrayList<>();
     int i=0;
         
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
            for(int i1=0; i1 < numberOfSheets; i1++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i1);
                 
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
                        if(cnt==0)
                        System.out.println(cell.getStringCellValue());
                        //check the cell type and process accordingly
                        switch(cell.getCellType()){
                        
                        case Cell.CELL_TYPE_BLANK:
                        	if(cnt>0)
                        	al.add(null);
                        	break;
                        case Cell.CELL_TYPE_FORMULA:
                        	if(cnt>0)
                        		al.add(cell.getCellFormula());
                        	break;
                        case Cell.CELL_TYPE_ERROR:
                        	if(cnt>0)
                        		al.add(String.valueOf(cell.getErrorCellValue()));
                        	break;
                       
                        case Cell.CELL_TYPE_STRING:
                        	if(cnt>0){
                            if(shortCode.equalsIgnoreCase("")){
                                shortCode = cell.getStringCellValue().trim();
                                al.add(shortCode);
                                
                            }else if(name.equalsIgnoreCase("")){
                                //2nd column
                                name = cell.getStringCellValue().trim();
                                al.add(name);
                            }else{
                            	//System.out.println("Inside else");
                                //random data, leave it
                               // System.out.println("Random data::"+cell.getStringCellValue());
                            	
                            		//System.out.println("Inside cnt block");
                            		String s=cell.getStringCellValue();
                            		//System.out.println(s);
                            		
                            			al.add(s);
                            		
                            	//System.out.println(al);
                            }
                            		//b[i].setBookId(bookId);
                            	
                            }
                            
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            //System.out.println("Random data::"+cell.getNumericCellValue());
                            al.add(""+cell.getNumericCellValue());
                            break;
                            
                        
                        }	
                       System.out.println(al);
                    
                    } //end of cell iterator
                    /*Country c = new Country(name, shortCode);
                    countriesList.add(c);*/
                    String val=null;
                    if(cnt>0){
                    	val=al.get(0);
                    }
                    if(cnt>0 && val!=null){
                        b[i]=new Books();
                        b[i].setBookId(val);
                        b[i].setAuthor(al.get(1));
                        b[i].setPublication(al.get(2));
                        b[i].setIsbn(al.get(3));
                        b[i].setLanguage(al.get(4));
                        b[i].setQuantity(al.get(5));
                        b[i].setDateOfPurchase(al.get(6));
                        b[i].setPrice(al.get(7));
                        b[i].setImage(al.get(8));
                        b[i].setNumberOfPages(al.get(9));
                        b[i].setBindingType(al.get(10));
                        System.out.println(b[i].getBookId());
                        i++;
                        }
                    al.clear();
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
        List<Books> list = readExcelData("/home/pepl-staff-001/Downloads/catalogueNEW.xlsx");
       // Main m=new Main();
        Main.main(null);
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