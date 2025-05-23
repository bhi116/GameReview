package nl.gamereview.web;

import java.security.Principal;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import nl.gamereview.domain.AppUser;
import nl.gamereview.domain.AppUserRepository;
import nl.gamereview.domain.GameRepository;
import nl.gamereview.domain.Review;
import nl.gamereview.domain.ReviewRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

    private final GameRepository gameRepository;
    private final ReviewRepository reviewRepository;
    private final AppUserRepository userRepository;

    AppController(GameRepository gameRepository, ReviewRepository reviewRepository, AppUserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    // Login sivu
    @GetMapping("login")
    public String login() {
        return "login";
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
    public String saveReview(@Valid @ModelAttribute Review review) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        AppUser user = userRepository.findByUsername(username);
        review.setUser(user);
        reviewRepository.save(review);
        System.out.println("Tallennettu arvostelu: " + review);
        return "redirect:/reviews";
    }

    // Poistetaan arvostelu ID:n perusteella
    @GetMapping("/reviews/delete/{id}")
    public String deleteReview(@PathVariable("id") Long revId, Principal principal) {
        Review review = reviewRepository.findById(revId).orElse(null);
    
        if (review != null && review.getUser().getUsername().equals(principal.getName())) {
            reviewRepository.deleteById(revId);
        } else {
            return "redirect:/reviews?error";
        }

        return "redirect:/reviews";
        }
    
    
}
