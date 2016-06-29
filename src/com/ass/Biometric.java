package com.ass;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class Biometric extends JFrame implements ActionListener 
{
	JButton b1,b2,b3;
	JTextField tf1;
	JTextArea ta;
	JPanel jp1,jp2,jp3;
	JScrollPane js;
	int rownum,cellnum;
	 Row row;
	 Cell cell;
	 XSSFWorkbook workbook;
	 XSSFSheet sheet ;
	 FileOutputStream out;
	public Biometric(String name) {
		this.setTitle(name);
		workbook = new XSSFWorkbook();
		sheet=workbook.createSheet("Employee Data");
		try {
			out = new FileOutputStream(new File("howtodoinjava_demo.ods"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jp1=new JPanel();
		b1=new JButton("Punch In");
		b2=new JButton("Punch Out");
		b3=new JButton("Generate");
		tf1=new JTextField(20);
		tf1.setEditable(false);
		//ta=new JTextArea(8,30);
		js=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		jp1.add(b1);jp1.add(b2);
		this.add(jp1);
		jp1.setLayout(new GridLayout(1,2));
		
		jp2=new JPanel();
		jp2.add(tf1);
		this.add(jp2);
		
		jp3=new JPanel();
		jp3.add(b3);
		this.add(jp3);
		
		this.setSize(500, 550);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1)
		{
	        //Blank workbook
	        
	         
	        //Create a blank sheet
	        
	        
			Date d=new Date();
			String s=d.toString();
			Object s1[]=s.split(" ");
			
			tf1.setText(""+s1[3]);
			
			
			row = sheet.createRow(rownum);
	         	System.out.println(cellnum);
	              cell = row.createCell(0);
	               if(s1[3] instanceof String)
	                    cell.setCellValue((String)s1[3]);
	                else if(s1[3] instanceof Integer)
	                    cell.setCellValue((Integer)s1[3]);
	            
	        
	        try
	        {
	            //Write the workbook in file system
	        
	           // workbook.write(out);
	        
	            System.out.println("howtodoinjava_demo.ods written successfully on disk.");
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
			
			
		}
		else if(ae.getSource()==b2)
		{
			  
			Date d=new Date();
			String s=d.toString();
			Object s1[]=s.split(" ");
			tf1.setText(""+s1[3]);
			System.out.println(cellnum);
			System.out.println("row="+rownum);
			   cell = row.createCell(1);
               if(s1[3] instanceof String)
                    cell.setCellValue((String)s1[3]);
                else if(s1[3] instanceof Integer)
                    cell.setCellValue((Integer)s1[3]);
            
        
        try
        {
            //Write the workbook in file system
        //    
           
           rownum++;
            System.out.println("howtodoinjava_demo.ods written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		}
		else if(ae.getSource()==b3)
		{
			try{
			 workbook.write(out);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new Biometric("Biometrics");

	}

}
