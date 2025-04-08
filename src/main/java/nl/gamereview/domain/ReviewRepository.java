package nl.gamereview.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{
    List<Review> findByRating(int rating);
    List<Review> findByGame(Game game);
}
