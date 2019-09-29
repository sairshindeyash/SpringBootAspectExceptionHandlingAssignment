package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Movie;
import com.example.exceptions.MovieNotFound;
import com.example.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	@Autowired
	MovieService service;

	@GetMapping("/test")
	public void display() {
		System.out.println("hello sb!!!");
	}

	@PostMapping(value = "/movie/add")
	public String addMovie(@RequestBody Movie movie) {
		service.addMovie(movie);
		return "Movie added";
	}

	@GetMapping(value = "/movies/all",produces={"application.json","application/xml"})
	public List<Movie> getAllMovies() {
		return service.getAllMovies();
	}
	
	@DeleteMapping(value="/movie/{id}",produces={"application.json","application/xml"})
	public String deleteMovie(@PathVariable Integer id){
		service.deleteMovieById(id);
		return "movie deletd : "+id;
	}

	@GetMapping(value="/movie/{id}")
	public Movie getMoviebyId(@PathVariable Integer id){
		return service.getMovieById(id).orElseThrow(()->new MovieNotFound("Movie with "+id + "not found"));
	}
	@PutMapping("/movie/{id}")
	public String updateMovieById(@PathVariable Integer id,@RequestBody Movie movie){
		Movie movie1=service.getMovieById(id).orElseThrow(()->new MovieNotFound("Movie with "+id + "not found"));
		movie1.setName(movie.getName());
		movie1.setGenre(movie.getGenre());
		service.addMovie(movie1);
		return "Updated movie : "+id;
	}
}
