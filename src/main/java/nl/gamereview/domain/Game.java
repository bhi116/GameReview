package nl.gamereview.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty
    private String title;
    @NotEmpty
    private String platform;
    @NotNull
    @Min(value = 1900, message = "Release year must be after 1900")
    @Max(value = 2100)
    private Integer releaseYear;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GameMode mode;
    

    public Game (){}


    public Game(String title, String platform, Integer releaseYear, Genre genre, GameMode mode) {
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


    public Integer getReleaseYear() {
        return releaseYear;
    }


    public void setReleaseYear(Integer releaseYear) {
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
