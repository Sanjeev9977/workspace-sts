package in.ashok.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import in.ashok.entity.Product;
import in.ashok.repo.ProductRepo;
import in.ashok.spns.Productspns;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	
	public  void getProductSpec(String name,Double minprice,Double maxprice) {
		
		Specification<Product> spec=Specification.where(null);
		
		if(name !=null) {
			spec=spec.and(Productspns.nameLike(name));
		}
		if(minprice !=null) {
			spec=spec.and(Productspns.priceLessThen(minprice));
		}
		if(maxprice !=null) {
			spec=spec.and(Productspns.priceGraterThen(maxprice));
		}
		List<Product> findall=repo.findAll(spec);
		findall.forEach(System.out::println);
		}
	
	public void save() {
		
		Product p1=new Product();
		p1.setCategery("Mobile");
		p1.setName("Iphone");
		p1.setPrice(60000.0);
		
		Product p2=new Product();
		p2.setCategery("Computer");
		p2.setName("Lenovo");
		p2.setPrice(80000.0);
		
		
		Product p3=new Product();
		p3.setCategery("Mobile");
		p3.setName("Poco");
		p3.setPrice(26000.0);
		
		
		repo.saveAll(Arrays.asList(p1,p2,p3));
		
		
	}

}
