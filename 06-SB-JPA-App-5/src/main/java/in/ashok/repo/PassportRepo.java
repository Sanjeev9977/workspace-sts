package in.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Passport;

public interface PassportRepo extends JpaRepository<Passport,Integer>{

}
