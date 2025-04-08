package nl.gamereview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameMode;
import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.Genre;
import nl.gamereview.domain.GenreRepository;


@DataJpaTest
public class GameRepoTest {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GenreRepository genreRepository;
 
    @Test
    public void createNewGame() {
        Genre shooter = genreRepository.findByName("shooter");
        Game game = new Game("Marvel Rivals", "PS5", 2024, shooter, GameMode.MULTIPLAYER);
        gameRepository.save(game);
        assertThat(game.getTitle()).isNotEmpty();
    }

    @Test
    public void findByTitle() {
        List<Game> games = gameRepository.findByTitle("Phasmophobia");
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getGenre().getName()).isEqualTo("Horror");
    }

    @Test
    public void deleteGame() {
        List<Game> games = gameRepository.findByTitle("Phasmophobia");
        if (!games.isEmpty()){
            Game poistaGame = games.get(0);
            Long id = poistaGame.getId();
            gameRepository.deleteById(id);

            Optional<Game> deleted = gameRepository.findById(id);
            assertThat(deleted).isEmpty();
        }
    }

}
