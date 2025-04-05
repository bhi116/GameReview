package nl.gamereview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nl.gamereview.domain.Game;
import nl.gamereview.domain.GameMode;
import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.Genre;
import nl.gamereview.domain.GenreRepository;
import nl.gamereview.domain.Review;
import nl.gamereview.domain.ReviewRepository;

@SpringBootApplication
public class GamereviewApplication {

	private static final Logger log = LoggerFactory.getLogger(GamereviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamereviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner tiedot(GameRepository gameRepository, ReviewRepository reviewRepository, GenreRepository genreRepository){
		return (args) -> {
			// Lisätään genrejä
			Genre horror = new Genre("Horror");
			Genre puzzle = new Genre("Puzzle");
			Genre adventure = new Genre("Adventure");
			Genre survival = new Genre("Survival");
			Genre shooter = new Genre("Shooter");
			Genre platform = new Genre("Platform");
			Genre action = new Genre("Action");
			Genre simulation = new Genre("Simulation");
			Genre roleplaying = new Genre("Role-play");
			Genre sports = new Genre("Sports");
			Genre strategy = new Genre("Startegy");
			Genre sandbox = new Genre("Sandbox");

			// Tallennetaan genret tietokantaan
			genreRepository.save(horror);
			genreRepository.save(puzzle);
			genreRepository.save(adventure);
			genreRepository.save(survival);
			genreRepository.save(shooter);
			genreRepository.save(platform);
			genreRepository.save(action);
			genreRepository.save(simulation);
			genreRepository.save(roleplaying);
			genreRepository.save(sports);
			genreRepository.save(strategy);
			genreRepository.save(sandbox);

			log.info("fetch all genres");
			for (Genre genre : genreRepository.findAll()){
				log.info(genre.toString());
			}

			// Lisätään pari peliä valmiiksi
			Game g1 = new Game("Phasmophobia", "PC", 2020, horror,GameMode.MULTIPLAYER);
			Game g2 = new Game("Overwatch 2", "PS5", 2023, shooter, GameMode.MULTIPLAYER);
			Game g3 = new Game("Dead by Daylight", "PS5", 2020, horror, GameMode.MULTIPLAYER);

			//Tallennetaan pelit tietokantaan
			gameRepository.save(g1);
			gameRepository.save(g2);
			gameRepository.save(g3);

			log.info("fetch all games");
			for (Game game : gameRepository.findAll()){
				log.info(game.toString());
			}

			// Lisätään pari arvostelua valmiiksi
			Review r1 = new Review(g1, 9, "Hauska ja pelottava peli kavereiden kanssa");
			Review r2 = new Review(g3, 9, "Hyvä peli");

			// Tallennetaan arvostelut tietokantaan
			reviewRepository.save(r1);
			reviewRepository.save(r2);

			log.info("fetch all reviews");
			for (Review review : reviewRepository.findAll()){
				log.info(review.toString());
			}
		};
	}

}
