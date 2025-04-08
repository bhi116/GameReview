package nl.gamereview;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.Review;
import nl.gamereview.domain.ReviewRepository;

@DataJpaTest
public class ReviewRepoTest {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GameRepository gameRepository;

    @Test
    public void createNewReview() {
        List<Game> games = gameRepository.findByTitle("Phasmophobia");
        Review review = new Review(games.get(0), 4, "Fun");
        reviewRepository.save(review);
        assertThat(review.getGame().getTitle()).isEqualTo("Phasmophobia");
    }

    @Test
    public void deleteReview() {
        List<Game> games = gameRepository.findByTitle("Phasmophobia");
        assertThat(games).isNotEmpty();
        Game game = games.get(0);
        List<Review> reviews = reviewRepository.findByGame(game);
        assertThat(reviews).isNotEmpty();
    
        Review deleteReview = reviews.get(0);
        reviewRepository.deleteById(deleteReview.getRevId());
    
        List<Review> muutReviews = reviewRepository.findByGame(game);
        assertThat(muutReviews).doesNotContain(deleteReview);
    }
}
