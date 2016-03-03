package com.td.classes;

import java.util.ArrayList;

public class Person {
	// fields
	public static final String ROLE_STUDENT = "student";
	public static final String ROLE_TEACHER = "teacher";

	// Image of person ////
	
	private String personId;  // unique person id for that college
	private String password;
	private String collegeId;  // college associated with student // [optional]
	private String role;
	
	private String name; // name of the person
	private String address;
	//private int booksTaken; // [optional]  booksInPossesion.size()
	private ArrayList <Book> booksInPossesion = new ArrayList <Book> ();
	private boolean bookBankFacility; 
	
	private ArrayList <Book> bookBankBooksInPossesion = new ArrayList <Book> ();
	
	private String degree;
	private String branch;
	private int yearOfAdmission;
	private int yearInDegree;
	private int rollNumber;
	//private int fine     // yet to decide
	
	
	
	
	// constructors
	public Person(String personId , String name) {
		this.personId = personId;
		this.name = name;
	}

	// methods
	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isBookBankFacility() {
		return bookBankFacility;
	}

	public void setBookBankFacility(boolean bookBankFacility) {
		this.bookBankFacility = bookBankFacility;
	}

	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public int getYearInDegree() {
		return yearInDegree;
	}

	public void setYearInDegree(int yearInDegree) {
		this.yearInDegree = yearInDegree;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	
	
	
//	public String toString() {
//		return this.getName() + " (" + this.getMaximumBooks() + " books)";
//	}
	
}

