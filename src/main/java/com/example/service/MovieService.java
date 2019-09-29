package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Movie;

public interface MovieService {
	public List<Movie> getAllMovies();
	public Movie addMovie(Movie movie);
	public void deleteMovieById(Integer id);
	public Optional<Movie> getMovieById(Integer id);
}
