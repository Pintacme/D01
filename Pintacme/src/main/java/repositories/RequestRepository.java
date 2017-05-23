
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	@Query("select r from Request r where r.customer.id=?1")
	Collection<Request> findLoggedRequests(int id);

	@Query("select r from Request r join r.budgets b where b.painter.id=?1")
	Collection<Request> findRequestDoBudgetPainterId(int id);
	
	@Query("select r from Request r join r.budgets b where r.work > now()")
	Collection<Request> findRequestToBudget(int id);
	
	@Query("select r from Request r join r.budgets b where b.status='ACCEPTED'")
	Collection<Request> findRequestWithBudgetAccepted();
	
	@Query("select r from Request r join r.budgets b where b.painter.id=?1")
	Collection<Request> findRequestWithBudgetPainterId(int id);


}
