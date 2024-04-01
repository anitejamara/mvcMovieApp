package com.mvcproject.mvcmovieapp.controller;

import com.mvcproject.mvcmovieapp.model.Movie;
import com.mvcproject.mvcmovieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        model.addAttribute("movie", new Movie());
        return "movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "edit-movie-details";
    }

    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable("id") Long id, @ModelAttribute Movie updatedMovie) {
        movieService.updateMovie(id, updatedMovie);
        return "redirect:/movies";
    }

    @PostMapping
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "edit_movie-details";
    }
}
