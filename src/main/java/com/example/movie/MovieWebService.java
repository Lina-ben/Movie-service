 package com.example.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;


@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class MovieWebService {
	   
	MovieRepo movieRepo;

	@Autowired
	public MovieWebService(MovieRepo movieRepo) {
		super();
		this.movieRepo = movieRepo;
		
	}
	
	@JsonView(View.Summary.class)
	@GetMapping("/all")
	public Iterable<Movie> getMovies(){
		
	 return movieRepo.findAll();
		
	}
	
	@JsonView(View.Summary.class)
	@GetMapping( value = "/title/{title}")
	 public List<Movie>  getMovieByTitle(@PathVariable String title) 
	{ 
		return movieRepo.findByTitleContaining(title) ;
		
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value = "/genre/{name}", method = RequestMethod.GET)
	 public Iterable<Movie> getMovieByGenre(@PathVariable String name) {
		
		return movieRepo.findMoviesByGenresName(name);
		
	}
		
	@JsonView(View.Summary.class)
	@RequestMapping(value = "/actor/{name}", method = RequestMethod.GET)
	 public Iterable<Movie> getMovieByActor(@PathVariable String name) {
		
		return movieRepo.findMoviesByActorsName(name);
		
	}
	
	@RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId) {
		
		return movieRepo.findMoviesByMovieid(movieId);
		
	}
}
	
	
	
	


