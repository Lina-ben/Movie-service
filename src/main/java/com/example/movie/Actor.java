package com.example.movie;

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
//import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.GenerationType;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name="Actor")
public class Actor {
	
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinTable(
	            name = "MovieActor",
	            joinColumns = {@JoinColumn(name = "actor_id")},
	            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
	    )
	 
	 @JsonBackReference
	 private Set<Movie> movies = new HashSet<>();
	 
	 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long actor_id ;
	
	@JsonView(View.Summary.class)
    String name ;

    
    
    public Actor() {
    }

   
    public long getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
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
		return "Actor [movies=" + movies + ", actor_id=" + actor_id + ", name=" + name + "]";
	}


    }

