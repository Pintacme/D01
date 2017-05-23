
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Budget;
import domain.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {

	@Query("select b from Budget b where b.request.discussion.id = ?1")
	Budget namePainterByBudget(int discussionId);
	
}
