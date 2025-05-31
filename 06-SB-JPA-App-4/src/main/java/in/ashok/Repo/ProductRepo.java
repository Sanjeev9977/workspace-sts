package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import in.ashok.entity.Product;

public interface ProductRepo extends JpaRepository<Product,String> {
	
	
    @Procedure(name = "Product_sp")
    void Product_sp(int month, int year);
	

}
