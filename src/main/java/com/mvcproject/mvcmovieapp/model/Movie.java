package com.mvcproject.mvcmovieapp.model;
// import java.util.List;

import jakarta.persistence.*;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String director;
   
    
    @Column(name="releaseYear")
    private int releaseYear;

    @Column(name = "averageRating") 
    private double averageRating;


    public Movie() {
    }

    public Movie(String title, int releaseYear, String genre, String director, double averageRating) {
            this.title = title;
            this.releaseYear = releaseYear;
            this.genre = genre;
            this.director = director;
            this.averageRating = averageRating;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
