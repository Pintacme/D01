
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Budget;
import domain.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {

	@Query("select b from Budget b where b.request.discussion.id = ?1")
	Budget namePainterByBudget(int discussionId);
	
	@Query("select b from Budget b where b.request.id = ?1 and b.status = 'ACCEPTED'")
	Budget budgetAcceptedByRequestId(int requestId);
	
	@Query("select d from Discussion d where d.request.customer.id = ?1")
	Collection<Discussion> findAllByCustomerId(int customerId);
	
}
