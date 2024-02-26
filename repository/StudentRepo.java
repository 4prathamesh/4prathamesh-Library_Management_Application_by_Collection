package org.LibraryManagement.repository;

import java.util.ArrayList;
import org.LibraryManagement.model.StudentModel;

public class StudentRepo {
	static ArrayList al1= new ArrayList();
	public boolean addStudent(StudentModel sModel) {
		al1.add(sModel);
		return al1.size()>0 ? true:false;
	}
	public int idsetter()
	{
		return al1.size();
	}
	public ArrayList getInfo() {
		
		return al1;
	}
	

}
