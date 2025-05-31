package in.ashok.Repo;

import java.util.List;

 
import in.ashok.entity.Product;

public interface ProductServiceInt {
	
	public Boolean saveproduct(Product product);
	
	public List<Product> getproduct();
	
	public Product finduseid(Integer id);
	
	void deleteProductById(Integer id);

}
