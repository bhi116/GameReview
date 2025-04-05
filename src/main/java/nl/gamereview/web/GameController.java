package nl.gamereview.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.GenreRepository;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GameController {

    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;

    public GameController(GameRepository gameRepository, GenreRepository genreRepository) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
    }

    // Näyttää pelilistan
    @GetMapping("/games")
    public String gameList(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "gamelist";
    }

    // Lisätään uusi peli
    @GetMapping("/games/newgame")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("genres", genreRepository.findAll());
        return "addgame";
    }

    // Tallennetaan peli
    @PostMapping("/games/savegame")
    public String saveGame(Game game) {
        gameRepository.save(game);
        System.out.println("Tallennettu peli: " + game);
        return "redirect:/games";
    }
    
    //Poistetaan peli
    @GetMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        gameRepository.deleteById(gameId);
        return "redirect:/games";
    }
}
