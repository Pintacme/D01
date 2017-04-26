package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select s from Customer s where s.userAccount.username=?1")
	Customer getByUsername(String username);
	
	
	@Query("select avg(c.age) from Customer c")
	Double avgAgeCustomer();
	
	@Query("select (select count(c)*1.0 from Customer c where c.genre='MAN')/count(m), (select count(c)*1.0 from Customer c where c.genre='WOMAN')/count(m) from Customer m")
	Collection<Object> ratioManWoman();
	
}
