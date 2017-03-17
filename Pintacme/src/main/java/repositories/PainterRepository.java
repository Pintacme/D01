package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Comment;
import domain.Painter;

@Repository
public interface PainterRepository extends JpaRepository<Painter, Integer> {

}
