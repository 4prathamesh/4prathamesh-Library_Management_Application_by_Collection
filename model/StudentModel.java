package org.LibraryManagement.model;
import java.util.*;
public class StudentModel {
	private int sid;
	private String name,email,contact;
	private String sBook;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getsBook() {
		return sBook;
	}
	public void setsBook(String sBook) {
		this.sBook = sBook;
	}
}
