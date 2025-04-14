package nl.gamereview.web;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameMode;
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
        model.addAttribute("gameModes", GameMode.values());
        model.addAttribute("genres", genreRepository.findAll());
        return "addgame";
    }

    // Haetaan kaikki GameMode-arvot
    @ModelAttribute("gameModes")
    public GameMode[] gameModes() {
        return GameMode.values();
    }

    // Tallennetaan peli
    @PostMapping("/games/savegame")
    public String saveGame(@Valid @ModelAttribute Game game) {
        gameRepository.save(game);
        System.out.println("Tallennettu peli: " + game);
        return "redirect:/games";
    }
    
    //Poistetaan peli ID:n perusteella
    @GetMapping("/games/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        gameRepository.deleteById(gameId);
        return "redirect:/games";
    }
}
