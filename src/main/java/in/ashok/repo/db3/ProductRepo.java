package in.ashok.repo.db3;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.db3.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
