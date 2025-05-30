package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
