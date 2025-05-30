package in.ashok.springjdbc;

import java.util.List;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

 
	@Override
	public void saveBook(int id,String Name,int price) {
		// TODO Auto-generated method stub
		
		boolean status=bookDao.save(id,Name,price);
		
		if(status)
			System.out.println("Record save Database");
		else
			System.out.println("Data insertion faild");
	}
	
	 
	
 
		
		


	@Override
	public void getName(int id) {
		// TODO Auto-generated method stub
		System.out.println(bookDao.findbyid(id));
	}


	@Override
	public void fachall() {
		// TODO Auto-generated method stub
		 List<Book> book = bookDao.findAll();
		    
		    // Print each BookDTO's details
		 System.out.println(book);
	}


	@Override
	public void update_data(int id,int price) {
		// TODO Auto-generated method stub
		
        boolean status=bookDao.Update(id,price);
		
		if(status)
			System.out.println("Record Updated");
		else
			System.out.println("Data Updatation faild");
		
	}


	@Override
	public void delet(int id) {
		// TODO Auto-generated method stub
        boolean status=bookDao.delet(id);
		
		if(status)
			System.out.println("Record deleted");
		else
			System.out.println("Data delet faild");
		
	}
	
	

}
