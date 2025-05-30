package in.ashok.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashok.Repo.ProductRepo;
import in.ashok.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public void saveProduct() {
		
		Product p=new Product();
		//p.setPid(3);
		p.setPname("car");
		p.setPrice(2000000.0);
		
		productRepo.save(p);
		
		System.out.println("Record saved....");
		
	}
	
	public void callProductSp(int month,int year) {
		
		productRepo.Product_sp(month, year);
	}
	

}
