package in.ashok.springjdbc;

import java.util.List;

public interface BookDao {
	
	public boolean save(int id,String Name,int price);
	
	public String  findbyid(int id);
	
	public List findAll();
	
	public boolean Update(int id ,int price);
    
	public boolean delet(int id); 
}
