package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Comment;
import domain.Painter;

@Repository
public interface PainterRepository extends JpaRepository<Painter, Integer> {

	@Query("select p from Painter p where p.userAccount.username=?1")
	Painter getPainterByUsername(String username);

	@Query("select b.painter from Budget b join b.request r join r.customer c where c.id=?1 and b.status='ACCEPTED' group by b.painter")
	Collection<Painter> findPaintersWorkedWithCustomerId(int id);
	
	@Query("select p from Painter p order by p.averageStart desc")
	Collection<Painter> getPaintersOrderByAverageStart();

}
