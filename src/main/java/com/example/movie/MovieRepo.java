package com.example.movie;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Integer> {
	
	
	List<Movie>  findByTitleContaining(String title);
	List<Movie> findMoviesByGenresName(String name);
	List<Movie> findMoviesByActorsName(String name);
	Movie findMoviesByMovieid(Integer Id);
	
}