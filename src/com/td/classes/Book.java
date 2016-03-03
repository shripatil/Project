package com.td.classes;

import java.util.ArrayList;

public class Book {
	
	// tha case where there are many books of same tyep
	// we need to decide the way we represnet ( store in db ) them
	
	// image of book [option ] // we can create central database for image of book for every library
	
	private String bookId; // unique id for that book in that library
	private String isbn;
	
	private String collegeId;  // college associated with book // [optional]
	private String title;
	private String author;
	private Person person;  // person who has taken this book [optional]
	private String dateOfIssue; // when book has issued to above person
	private String dateOfReturn; // automatic calculate depending on college rule
	private int numberOfPages;  // [optional]
	private String bindingType; // [optional]
	private int yearOfPurchase;
	private String language;
	private boolean renewable; // can we renew it ? depends in that college defined by college
	
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	//ArrayList <String> tags = new ArrayList <String> (); // [optonal]
	
	// books history should reveal that when it was taken by whome and for how many days
	// so we can calculate its usability
	
	
	
	// constructor
/*	public Book(String bookId , String title , String author ) {
		//Date 
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}*/

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	public int getYearOfPurchase() {
		return yearOfPurchase;
	}

	public void setYearOfPurchase(int yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isRenewable() {
		return renewable;
	}

	public void setRenewable(boolean renewable) {
		this.renewable = renewable;
	}
	
	// methods
	
	
	
	
}
