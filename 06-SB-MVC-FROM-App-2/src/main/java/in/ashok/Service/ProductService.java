package in.ashok.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Repo.ProductRepo;
import in.ashok.Repo.ProductServiceInt;
import in.ashok.entity.Product;

@Service
public class ProductService implements ProductServiceInt {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public Boolean saveproduct(Product product) {
		
		//Product p=new Product();
	 
		//p.setName(product.getName());
		//p.setPrice(product.getPrice());
		//p.setQuantity(product.getQuantity());
		
		productRepo.save(product);
		
		return true;
	}
	
	public List<Product> getproduct() {
		
		 
		 List<Product> p=productRepo.findAll();
	 	
		return p;
	}
	
    public Product finduseid(Integer id) {
		
		  Optional<Product> product = productRepo.findById(id); if(product.isPresent())
		  { return product.get(); } throw new NoSuchElementException("Product with ID "
		  + id + " not found");
		  
    	
    	//return productRepo.findById(id).orElseGet(() -> new Product());
    }
    public void deleteProductById(Integer id) {
		
    	if (!productRepo.existsById(id)) {
            throw new NoSuchElementException("Product with ID " + id + " not found.");
        }
        productRepo.deleteById(id);
    }
}
