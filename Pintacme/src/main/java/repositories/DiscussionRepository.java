
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Discussion;
import domain.Material;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {

}
