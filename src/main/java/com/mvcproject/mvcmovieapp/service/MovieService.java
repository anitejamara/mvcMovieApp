package com.mvcproject.mvcmovieapp.service;

import com.mvcproject.mvcmovieapp.model.Movie;
import com.mvcproject.mvcmovieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setAverageRating(updatedMovie.getAverageRating());
            return movieRepository.save(existingMovie);
        } else {
            throw new IllegalArgumentException("Movie with ID " + id + " not found");
        }
    }
}

