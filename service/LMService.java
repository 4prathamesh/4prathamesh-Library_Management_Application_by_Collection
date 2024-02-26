package org.LibraryManagement.service;
import java.util.*;
import org.LibraryManagement.model.LMModel;
import org.LibraryManagement.repository.LMRepository;

public class LMService {
	LMRepository lmRepo= new LMRepository();
	LMModel lmModel;
	
	public boolean isAddBook(LMModel lmModel) {
		this.lmModel=lmModel;
		//logi for id 
		int Bid=lmRepo.idSetter();
		Bid+=1;
		lmModel.setId(Bid);
		return lmRepo.isAddBook(lmModel);
	}

	public ArrayList getAllBook()
	{
		return lmRepo.getAllBook();
	}



	
	
	
//	public ArrayList getCountCaty()
//	{
//		ArrayList al=lmRepo.getAllBook();
//		//ArrayList al2=new ArrayList();
//		int count;
//		boolean  b;
//		for(int i=0;i<al.size()-1;i++)
//		{
//			Object obj=al.get(i);
//			LMModel lmModel=(LMModel)obj;
//			count=1;
//			b=true;
//			for(int j=i+1;j<al.size();j++)
//			{
//				Object obj1=al.get(j);
//				LMModel lmModel2=(LMModel)obj1;
//				if(lmModel.getCategory().equals(lmModel2.getCategory()))
//				{
//					count++;
//					b=false;
//					lmModel2.setCategoryCount(0);
//					
//					//al2.add(null);
//				
//				}
//			}
//			if((count>1 || b)&& lmModel.getCategoryCount()>0)
//			{
//				lmModel.setCategoryCount(count);
//				
//			}
//		}
//		return al;
}
