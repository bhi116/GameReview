package nl.gamereview.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.Review;
import nl.gamereview.domain.ReviewRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

    private final GameRepository gameRepository;
    private final ReviewRepository reviewRepository;

    AppController(GameRepository gameRepository, ReviewRepository reviewRepository) {
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
    }

    // Aloitussivu, jolla näkyy arvostelut
    @GetMapping("/reviews")
    public String reviewList(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviewlist";
    }

    // Uuden review lisäys
    @GetMapping("/reviews/new")
    public String addReview(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("games", gameRepository.findAll());
        return "addreview";
    }

    // Tallennetaan review
    @PostMapping("/reviews/save")
    public String saveReview(@ModelAttribute Review review) {
        reviewRepository.save(review);
        System.out.println("Tallennettu arvostelu: " + review);
        return "redirect:/reviews";
    }

    // Poistetaan arvostelu
    @GetMapping("/reviews/delete/{id}")
        public String deleteReview(@PathVariable("id") Long revId, Model model) {
            reviewRepository.deleteById(revId);
            return "redirect:/reviews";
        }
    
    
}
