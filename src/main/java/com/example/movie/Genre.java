package com.example.movie;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.GenerationType;

@Entity
@Table(name="Genre")
public class Genre {
	
	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinTable(
	            name = "MovieGenre",
	            joinColumns = {@JoinColumn(name = "genre_id")},
	            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
	    )
	    @JsonBackReference
	    private Set<Movie> movies = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long genre_id;
	
	@JsonView(View.Summary.class)
    String name;

   
    public long getGenre_id() {
        return genre_id;
    }
    
    public Genre() {
		super();
	}


	public Genre(String name) {
		super();
		this.name = name;
	}

    
	public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public Set<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + genre_id +
                ", name='" + name + '\'' +
                '}';
    }
}

