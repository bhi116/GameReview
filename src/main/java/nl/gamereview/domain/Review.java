package nl.gamereview.domain;

import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long revId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Size(max = 255, message = "Comment cannot be longer than 255 characters")
    private String comment;

    public Review (){}

    public Review(Game game, int rating, AppUser user, String comment) {
        this.game = game;
        this.rating = rating;
        this.user = user;
        this.comment = comment;
    }

    public Long getRevId() {
        return revId;
    }

    public void setRevId(Long revId) {
        this.revId = revId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Review [revId=" + revId + ", game=" + game + ", rating=" + rating + ", user=" + user + ", comment="
                + comment + "]";
    }
    
}
