package nl.gamereview.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String platform;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private GameMode mode;
    

    public Game (){}


    public Game(String title, String platform, int releaseYear, Genre genre, GameMode mode) {
        this.title = title;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.mode = mode;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getPlatform() {
        return platform;
    }


    public void setPlatform(String platform) {
        this.platform = platform;
    }


    public int getReleaseYear() {
        return releaseYear;
    }


    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public Genre getGenre() {
        return genre;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public GameMode getMode() {
        return mode;
    }


    public void setMode(GameMode mode) {
        this.mode = mode;
    }


    @Override
    public String toString() {
        return "Game [id=" + id + ", title=" + title + ", platform=" + platform + ", releaseYear=" + releaseYear
                + ", genre=" + genre + ", mode=" + mode + "]";
    }
  

}
