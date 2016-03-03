

import java.util.ArrayList;

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
		
		arr=Books.al;
		Books b[]=new Books[arr.size()];
				for(int i=0;i<arr.size();i++)
				{
					b[i]=new Books();
					//b[i].setAuthor(author);=
					
				}
		
		//s.persist(u);
		
		t.commit();
		System.out.println("saved");
		s.close();
	}

}
