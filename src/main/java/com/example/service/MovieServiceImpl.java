package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Movie;
import com.example.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository movieRepository;
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie addMovie(Movie movie){
		return movieRepository.save(movie);
	}
	
	public Optional<Movie> getMovieById(Integer id){
		return movieRepository.findById(id);
	}

	@Override
	public void deleteMovieById(Integer id) {
		movieRepository.deleteById(id);
		
	}
}
