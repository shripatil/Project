

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.td.classes.Books;

public class Main 
{
	public static void main(String[] args) {
		ArrayList<String> arr=null;
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		
		
		int cnt=ReadExcelFileToList.cnt;
		Books b[]=ReadExcelFileToList.b;
		for(int i=0;i<b.length;i++)
		{
			if(b[i]!=null){
			s.persist(b[i]);
			}
			
		}
		
		t.commit();
		System.out.println("saved");
	
		s.close();
	}

}
