package com.mvcproject.mvcmovieapp.repository;

import com.mvcproject.mvcmovieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Define additional methods for querying movie data if needed
}

