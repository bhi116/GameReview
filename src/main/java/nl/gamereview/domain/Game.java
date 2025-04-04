package nl.gamereview.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String platform;
    private int releaseYear;

    @Enumerated(EnumType.STRING)
    private GameMode mode;
    

    public Game (){}


    public Game(String name, String platform, int releaseYear, GameMode mode) {
        this.name = name;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.mode = mode;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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


    public GameMode getMode() {
        return mode;
    }


    public void setMode(GameMode mode) {
        this.mode = mode;
    }


    @Override
    public String toString() {
        return "Game [id=" + id + ", name=" + name + ", platform=" + platform + ", releaseYear=" + releaseYear
                + ", mode=" + mode + "]";
    }

  

}
