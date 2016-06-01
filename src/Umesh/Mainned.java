package Umesh;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.td.classes.Books;

public class Mainned {
	
	public static void main(String[] args) {

		NewClass.path="C:\\Git Project\\catalogueNEW.xlsx";
		int r=NewClass.getSheet("Sheet1").getRows(); // As per my opinion these values should be fixed.
		int c=NewClass.getSheet("Sheet1").getCols();
		NewClass.setCurrentRow(0);
		System.out.println(r+" "+c);
		
		System.out.println();
		System.out.println();
		
		ArrayList <String> dbListBooks = new ArrayList <String>();
		Books b[]=new Books[33];
		int i=0,cnt=0;
		for (int row =0 ; row < r ; row ++) {
			NewClass.setCurrentRow(row);
			String finals = "";
			for ( int col =0; col < c ; col ++) {
				String temp = NewClass.getSheet("Sheet1").getCellData(col);
				
				finals = finals + temp + "\t\t\t";
				
				dbListBooks.add(temp);
				
			}
			if(cnt>0){
				String id=dbListBooks.get(0);
				if(id!=null && !id.equals(" ")){
			b[i]=new Books();
		    b[i].setBookId(id);
            b[i].setTitle(dbListBooks.get(1));
            b[i].setAuthor(dbListBooks.get(2));
            b[i].setPublication(dbListBooks.get(3));
            b[i].setIsbn(dbListBooks.get(4));
            b[i].setLanguage(dbListBooks.get(5));
            b[i].setQuantity(dbListBooks.get(6));
            b[i].setDateOfPurchase(dbListBooks.get(7));
            b[i].setPrice(dbListBooks.get(8));
            b[i].setImage(dbListBooks.get(9));
            b[i].setNumberOfPages(dbListBooks.get(10));
            b[i].setBindingType(dbListBooks.get(11));
            i++;
				}
			}
			cnt++;
			dbListBooks.clear();
			
			/*System.out.println(finals);
			System.out.println();*/
		}
		
		for(int j=0;j<b.length;j++)
		{
			System.out.println(b[j]);
		}
		
		
		Configuration cfg=new Configuration();
		//cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		
		
		
		for(int k=0;k<b.length;k++)
		{
			if(b[k]!=null){
			s.persist(b[k]);
			}
			
			
		}
		
		t.commit();
		s.close();
		System.out.println("saved");
	
	}

}
