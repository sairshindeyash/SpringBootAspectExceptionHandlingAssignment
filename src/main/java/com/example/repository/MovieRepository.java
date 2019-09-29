package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{
	public List<Movie> findAll();
	public Movie save(Movie movie);
	public Optional<Movie> findById(Integer id);
	public void deleteById(Integer id);
}
