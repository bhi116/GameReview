package nl.gamereview.domain;

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
    private String comment;

    public Review (){}

    public Review(Game game, int rating, String comment) {
        this.game = game;
        this.rating = rating;
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
        return "Review [revId=" + revId + ", game=" + game + ", rating=" + rating + ", comment=" + comment + "]";
    }

}
