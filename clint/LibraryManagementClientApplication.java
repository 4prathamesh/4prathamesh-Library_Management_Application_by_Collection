package org.LibraryManagement.clint;
import java.util.*;

import javax.sound.midi.Soundbank;

//import javax.sound.midi.Soundbank;
import org.LibraryManagement.model.LMModel;
import org.LibraryManagement.model.StudentModel;
import org.LibraryManagement.service.LMService;
import org.LibraryManagement.service.StudentService;
public class LibraryManagementClientApplication {
	public static void main(String x[])
	{
		LMService lmService= new LMService();
		Scanner sc= new Scanner (System.in);
		LMModel lmModel;
		ArrayList al ;
		ArrayList temp;
		StudentModel sModel = new StudentModel();
		StudentService sService= new StudentService();
		do
		{
			System.out.println("***************************************************************");
			System.out.println("*\t1. Add New Books in Collection");
			System.out.println("*\t2. View All Books ");
			System.out.println("*\t3. Count Category wise books");
			System.out.println("*\t4. Display Category wise books with info");
			System.out.println("*\t5. Display author wise books");
			System.out.println("*\t6. Add New Students ");
			System.out.println("*\t7. Issue book to students");
			System.out.println("*\t8. Show Stock after book issue");
			System.out.println("*\t9. View student wise books ");
			System.out.println("*\t10. Delete book by author ");
			System.out.println("***************************************************************");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
//				1. Add New Books in Collection
				String name,author,pub;
				sc.nextLine();
				System.out.println("enter the name of book, author and publication");
				name=sc.nextLine();
//				if(lmService.getAllBook().size()>0)
//				{
//					
//				}
				author=sc.nextLine();
				pub=sc.nextLine();
				System.out.println("enter the category of book");
				String category=sc.nextLine();
				System.out.println("enter the book price");
				//int id=sc.nextInt();
				int price=sc.nextInt();
				
				lmModel=new LMModel();
				//lmModel.setId(id);
				lmModel.setPrice(price);
				lmModel.setName(name);
				lmModel.setAuthor(author);
				lmModel.setPub(pub);
				lmModel.setCategory(category);
				
				//hs.add(category);
				//lmModel.setCategoryStatus(hs);
				lmModel.setStatus(true);
				boolean b=lmService.isAddBook(lmModel);
				if(b)
				{
					System.out.println("book is add");
				}
				else
				{
					System.out.println("book is not add");
				}
				break;
			case 2:
//				View All Books
				System.out.println("book in library");
				ArrayList al1=lmService.getAllBook();
				if(al1!=null)
				{
					for(Object obj:al1)
					{
						lmModel=(LMModel)obj;
						System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
						+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
						if(lmModel.isStatus())
						{
							System.out.println("book is Avalabel");
						}
						else
						{
							System.out.println("book is NOT Avalabel");
						}
					}
				}
				
				break;
			case 3:
//				Count Category wise books
				al=lmService.getAllBook();
				//al=lmService.getCountCaty();
//				al=lmService.getAllBook();
//				if(al!=null)
//				{
//					for(int i=0;i<al.size();i++)
//					{
//						Object obj=al.get(i);
//						lmModel=(LMModel)obj;
////						Object obj2=al2.get(i);
//						if(lmModel.getCategoryCount()>0)
//						{
//							System.out.println("Category: "+lmModel.getCategory()+"\tCount "+lmModel.getCategoryCount());
//						}
//						
//					}
					int index=0;
					for(Object obj:al)
					{
						lmModel=(LMModel)obj;
						String cat=lmModel.getCategory();
						int count=0;
						for(int i=index;i<al.size();i++)
						{
							Object obj1=al.get(i);
							LMModel lmModel1=(LMModel)obj1;
							if(lmModel1.getCategory().equals(cat))
							{
								count++;
							}
						}
						boolean a=true;
						for(int j=0;j<index;j++)
						{
							Object obj1=al.get(j);
							LMModel lmModel1=(LMModel)obj1;
							if(lmModel1.getCategory().equals(cat))
							{
								a=false;
								break;
							}
						}
						if(a)
						{
							//lmModel.setCategoryStatus(lmModel.getCategory());
								System.out.println("Category: "+cat+"\tCount "+count);
						}
							index++;
					}
//				}
				break;
			case 4:
//				Display Category wise books with info
				temp=new ArrayList();
				al=lmService.getAllBook();
				
				for(Object obj:al)
				{
					lmModel=(LMModel)obj;
					String str=lmModel.getCategory();
					if(!temp.contains(str))
					{
						temp.add(str);
					}
				}
				for(Object obj:temp)
				{
					String str=(String)obj;
					System.out.println("Category---"+str);
					for(Object obj1:al)
					{
						lmModel=(LMModel)obj1;
						if(lmModel.getCategory().equals(str))
						{
							System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
							+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
						}
					}
				}
//				Object obj=al;
//
//					lmModel=(LMModel)obj;
//					ArrayList temp=lmModel.getCategoryStatus();
//					for(Object obj1:temp)
//					{
//						String str1=(String)obj1;
//						for(Object obj2:al)
//						{
//							lmModel=(LMModel)obj2;
//							System.out.println("Category---"+str1);
//							if(str1.equals(lmModel.getCategory()))
//							{
//								System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
//								+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
//							}
//						}
//					}
						
				//for(int i=0;i<array.le)
//				al=lmService.getAllBook();
//				ArrayList al2=al;
//				for(int i=0;i<al2.size();i++)
//				{
//					Object obj=al2.get(i);
//					lmModel =(LMModel)obj;
//					String str=lmModel.getCategory();
//					//if()
//					//{
//						for(int j=i;j<al2.size();j++)
//						{
//							Object obj1=al2.get(j);
//							LMModel lmModel1=(LMModel)obj1;
//							if(str.equals(lmModel1.getCategory()))
//							{//								System.out.println("Category\n"+str);
//								System.out.println("\nBook id: "+lmModel1.getId()+"\tName: "+lmModel1.getName()+"\tAuthor: "+lmModel1.getAuthor()
//								+"\tPublication: "+lmModel1.getPub()+"\nPrice: "+lmModel1.getPrice()+"\tcategory: "+lmModel1.getCategory());
//								
//							}
//						}
//					//}
//				}
				break;
			case 5:
//				5. Display author wise books
				temp=new ArrayList();
				al=lmService.getAllBook();
				
				for(Object obj:al)
				{
					lmModel=(LMModel)obj;
					String str=lmModel.getAuthor();
					if(!temp.contains(str))
					{
						temp.add(str);
					}
				}
				for(Object obj:temp)
				{
					String str=(String)obj;
					System.out.println("Author---"+str);
					for(Object obj1:al)
					{
						lmModel=(LMModel)obj1;
						if(lmModel.getAuthor().equals(str))
						{
							System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
							+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
						}
					}
				}
				break;
			case 6:
//				Add New Students
				System.out.println("enter the student dedails");
				//System.out.println("Enetr the student id");
				//int sid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enetr the Name of student");
				String sname=sc.nextLine();
				System.out.println("Enetr the Email of student");
				String email=sc.nextLine();
				System.out.println("Enetr the contact of student");
				String contact=sc.nextLine();
				//sModel.setSid(sid);
				sModel.setName(sname);
				sModel.setEmail(email);
				sModel.setContact(contact);
				boolean b1=sService.addStudent(sModel);
				if(b1)
				{
					System.out.println("Student add **");
				}
				else
				{
					System.out.println("Student NOT add **");
				}
				break;
			case 7:
//				7. Issue book to students 
				System.out.println("enter the id of Student");
				int id=sc.nextInt();
				
				boolean flag=false;
				ArrayList alt=sService.getInfo();
				Iterator it2=alt.iterator();
				while(it2.hasNext())
				{
					Object obj=it2.next();
					sModel=(StudentModel)obj;
					System.out.println(sModel.getSid());
					int tempid=sModel.getSid();
					if(tempid==id)
					{
						flag=true;
						break;
					}
				}
				if(flag)
				{
					sc.nextLine();
					System.out.println("Enetr the Book name");
					name=sc.nextLine();
					al=sService.issueBstudent(name);
					ArrayList al2=sService.getInfo();
					Iterator it3=al2.iterator();
					while(it3.hasNext())
					{
						Object obj1=it3.next();
						sModel=(StudentModel)obj1;
						if(id==sModel.getSid())
						{
							sModel.setsBook(name);
							//System.out.println(sModel.getsBook());
						}
					}
					
//					lmModel=(LMModel)obj;
//					System.out.println("Book Issue by Student");
//					System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
//					+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
				}
				else
				{
					System.out.println("id is invalid");
				}
				
				break;
			case 8:
//				8. Show Stock after book issue
				al=lmService.getAllBook();
				if(al!=null)
				{
					for(Object obj1:al)
					{
						lmModel=(LMModel)obj1;
						System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
						+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
						if(lmModel.isStatus())
						{
							System.out.println("----book is Avalabel----");
						}
						else
						{
							System.out.println("----book is NOT Avalabel----");
						}
					}
				}
				break;
			case 9:
//				9. View student wise books 
//				ArrayList Sal=sService.getInfo();
//				Iterator it=Sal.iterator();
//				while(it.hasNext())
//				{
//					Object obj=it.next();
//					sModel=(StudentModel)obj;
//					System.out.println(sModel.getsBook());
//				}
				
				ArrayList Sal=sService.getInfo();
				System.out.println("size   "+Sal.size());
				al=lmService.getAllBook();
				Iterator it=Sal.iterator();
				while(it.hasNext())
				{
					Object obj=it.next();
					sModel=(StudentModel)obj;
					System.out.println("name of Student: "+sModel.getName());
					Iterator it1=al.iterator();
					while(it1.hasNext())
					{
						obj=it1.next();
						lmModel=(LMModel)obj;
						String str=lmModel.getName();
						if(sModel.getsBook().equals(str))
						{
							System.out.println("Book id: "+lmModel.getId()+"\tName: "+lmModel.getName()+"\tAuthor: "+lmModel.getAuthor()
							+"\tPublication: "+lmModel.getPub()+"\nPrice: "+lmModel.getPrice()+"\tcategory: "+lmModel.getCategory());
						}
					}
				}
				break;
			case 10:
//				10. Delete book by author
				sc.nextLine();
				al=lmService.getAllBook();
				Iterator it4=al.iterator();
				System.out.println("enter the author name");
				String auth=sc.nextLine();
				while(it4.hasNext())
				{
					Object obj=it4.next();
					lmModel=(LMModel)obj;
					
					if(auth.equals(lmModel.getAuthor()))
					{
						it4.remove();
					}

				}
				break;
			}
		}while(true);
		
	}
}
