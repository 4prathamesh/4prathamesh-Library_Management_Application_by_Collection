package org.LibraryManagement.service;

import java.util.ArrayList;

import org.LibraryManagement.model.LMModel;
import org.LibraryManagement.model.StudentModel;
import org.LibraryManagement.repository.LMRepository;
import org.LibraryManagement.repository.StudentRepo;

public class StudentService {
	StudentModel sModel;
	LMModel lmModel;
	LMRepository lmRepo=new LMRepository();
	StudentRepo sRepo = new StudentRepo();
	//ArrayList sal;
	public boolean addStudent(StudentModel sModel)
	{
		int sid=sRepo.idsetter();
		sid+=1;
		sModel.setSid(sid);
		return sRepo.addStudent(sModel);
	}
	public ArrayList issueBstudent(String name) {
		ArrayList al=lmRepo.getAllBook();
		for(Object obj:al)
		{
			lmModel=(LMModel)obj;
			if(name.equals(lmModel.getName()))
			{
				lmModel.setStatus(false);
				//sModel.setName(name);
				//System.out.println("******");
				return al;
			}
		}
		return al;
	}
	public ArrayList getInfo()
	{
		return sRepo.getInfo();
	}
}
