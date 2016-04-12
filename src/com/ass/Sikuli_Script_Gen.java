package com.ass;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sikuli_Script_Gen extends JFrame implements ActionListener 
{
	JButton b1,b2;
	JTextField tf1;
	JTextArea ta;
	JPanel jp1,jp2,jp3;
	JScrollPane js;
	public Sikuli_Script_Gen(String name) {
		this.setTitle(name);
		jp1=new JPanel();
		b1=new JButton("Start");
		b2=new JButton("Stop");
		tf1=new JTextField(20);
		ta=new JTextArea(8,30);
		js=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		jp1.add(b1);jp1.add(b2);
		this.add(jp1);
		jp1.setLayout(new GridLayout(1,2));
		
		jp2=new JPanel();
		jp2.add(tf1);
		this.add(jp2);
		
		jp3=new JPanel();
		jp3.add(js);
		this.add(jp3);
		
		this.setSize(500, 550);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1)
		{
			ta.append(tf1.getText());
		}
		else if(ae.getSource()==b2)
		{
			ta.append(tf1.getText());
		}
	}
	public static void main(String[] args) {
		new Sikuli_Script_Gen("Sikuli Script Generator");

	}

}
