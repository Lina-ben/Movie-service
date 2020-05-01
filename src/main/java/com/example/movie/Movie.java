package com.example.movie;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.movie.Actor;
import com.example.movie.Genre;
import com.example.movie.View;
import com.example.movie.View.Summary;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.GenerationType;

@Entity
@Table(name="Movie")
public class Movie {
	
	    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    @JsonManagedReference
	    @JsonView(View.Summary.class)
	    private Set<Actor> actors = new HashSet<>();
	    
	    @ManyToMany(mappedBy = "movies", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    @JsonManagedReference
	    @JsonView(View.Summary.class)
	    private Set<Genre> genres = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(View.Summary.class)
    private Integer movieid;

	@JsonView(View.Summary.class)
 	String title;
	@JsonView(View.Summary.class)
    String Desc ;
	
	@JsonView(View.Summary.class)
    float rating ;
	
	@JsonView(View.Summary.class)
    String director ;
	

    
    
    public Movie() {
  		super();
  	}
    
    public Movie(String title,String Desc, int rating,String director ) {
    	
    	this.title = title ;
    	this.Desc = Desc ;
    	this.title = title ;
    	this.rating = rating ;
    	this.director = director ;
    }

    
    public Integer getMovie_id() {
        return movieid;
    }

    public void setMovie_id(int movieid) {
        this.movieid = movieid;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public Set<Genre> getGenres() {
        return genres;
    }
    
    
   
    public Set<Actor> getActors() {
        return actors;
    }
    

    @Override
    public String toString() {
        return "movie{" +
                "id=" + movieid +
                ", title='" + title + '\'' +
                ", Desc='" + Desc + '\'' +
                ", rating=" + rating +
                '}';
    }
}

