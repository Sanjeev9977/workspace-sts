package in.ashok.spns;

import org.springframework.data.jpa.domain.Specification;

import in.ashok.entity.Product;

public class Productspns {
	
	
	
	public static Specification<Product> nameLike(String name){
		return (root,query,criteriaBuilder)-> criteriaBuilder.like(root.get("name"),"%" +name+"%");
		
	}
	public static Specification<Product> priceLessThen(double price){
		return (root,query,criteriaBuilder)-> criteriaBuilder.lessThan(root.get("price"),price);
		
	}
	public static Specification<Product> priceGraterThen(double price){
		return (root,query,criteriaBuilder)-> criteriaBuilder.greaterThan(root.get("price"),price);
		
	}

}
