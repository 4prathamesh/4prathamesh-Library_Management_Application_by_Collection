package org.LibraryManagement.repository;
import java.util.*;
import org.LibraryManagement.model.LMModel;

public class LMRepository {
	static ArrayList al= new ArrayList();
	LMModel lmModel;
	public boolean isAddBook(LMModel lmModel) {
		this.lmModel=lmModel;
		al.add(lmModel);
		return al.size()>0 ? true: false;
	}
	
	public ArrayList getAllBook()
	{
		return al.size()>0 ? al:null;
	}


	
	public int idSetter()
	{
		return al.size();
	}


}
