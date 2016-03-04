import java.io.*;

public class FileDemo {

	public static void main(String[] args) throws IOException 
	{
		FileReader fr=new FileReader("a.txt");
		BufferedReader br=new BufferedReader(fr);
		String s;
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
		

	}

}
