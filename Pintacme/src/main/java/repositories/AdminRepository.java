package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

	@Query("select a from Administrator a where a.userAccount.username=?1")
	Administrator getAdministratorByUsername(String username);
}
