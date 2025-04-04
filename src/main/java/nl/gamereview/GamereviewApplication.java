package nl.gamereview;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.ReviewRepository;

@SpringBootApplication
public class GamereviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamereviewApplication.class, args);
	}

	@Bean
	public CommandLineRunner omatReviews(GameRepository gameRepository, ReviewRepository reviewRepository){
		return (args) -> {
			
		}
	}

}
