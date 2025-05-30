package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.enity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	public Customer findByUname(String uname);
	
	

}
