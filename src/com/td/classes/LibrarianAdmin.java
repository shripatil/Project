package com.td.classes;

public class LibrarianAdmin {
	
	
	private String collegeId;
	private String password;
	private static int finePerDayforStudent;
	private static int dayLimitStudent;
	private static int dayLimitTeacher;
	private static int finePerDayforTeacher;
	
	private static int bookLimitTeacher;
	private static int bookLimitStudent;
	
	
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static int getFinePerDayforStudent() {
		return finePerDayforStudent;
	}
	public static void setFinePerDayforStudent(int finePerDayforStudent) {
		LibrarianAdmin.finePerDayforStudent = finePerDayforStudent;
	}
	public static int getDayLimitStudent() {
		return dayLimitStudent;
	}
	public static void setDayLimitStudent(int dayLimitStudent) {
		LibrarianAdmin.dayLimitStudent = dayLimitStudent;
	}
	public static int getDayLimitTeacher() {
		return dayLimitTeacher;
	}
	public static void setDayLimitTeacher(int dayLimitTeacher) {
		LibrarianAdmin.dayLimitTeacher = dayLimitTeacher;
	}
	public static int getFinePerDayforTeacher() {
		return finePerDayforTeacher;
	}
	public static void setFinePerDayforTeacher(int finePerDayforTeacher) {
		LibrarianAdmin.finePerDayforTeacher = finePerDayforTeacher;
	}
	public static int getBookLimitTeacher() {
		return bookLimitTeacher;
	}
	public static void setBookLimitTeacher(int bookLimitTeacher) {
		LibrarianAdmin.bookLimitTeacher = bookLimitTeacher;
	}
	public static int getBookLimitStudent() {
		return bookLimitStudent;
	}
	public static void setBookLimitStudent(int bookLimitStudent) {
		LibrarianAdmin.bookLimitStudent = bookLimitStudent;
	}
	
	
	
	
	

}
