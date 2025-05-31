package in.ashok.springjdbc;

import java.util.List;

public interface BookService {
	
	public void saveBook(int id,String Name,int price);
	
	public void getName(int id);
	
	public void fachall();
	
	public void update_data(int id,int price);
	
	public void delet(int id);

}
