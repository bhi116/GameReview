package nl.gamereview.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameRepository;


@RestController
@RequestMapping("/api/games")
public class GameRestController {

    private final GameRepository gameRepository;

    public GameRestController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Haetaan kaikki pelit
    @GetMapping
    public List<Game> getAllGames() {
        return (List<Game>)gameRepository.findAll();
    }

    // Haetaan peli ID:n perusteella
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    // Lisätään uusi peli
    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    // Poistetaan peli ID:n perusteella
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }
}

