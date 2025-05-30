package in.ashok.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashok.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer> {

}
