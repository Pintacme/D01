
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

	@Query("select b from Budget b where b.id = ?1")
	Budget findOne(int budgetId);

}
