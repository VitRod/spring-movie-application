package com.vit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.vit.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vit.domain.Actor;
import com.vit.domain.Movie;
import com.vit.repository.MovieRepository;

@SpringBootApplication
public class SpringThymeleafMovieAppApplication implements CommandLineRunner{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafMovieAppApplication.class, args);
	}

	
	@Override
	public void run(String... args) {
		Actor john1 = new Actor("Keanu", "Reeves", "All");
		Actor john2 = new Actor("Will", "Smith", "Detective");
		Actor john3 = new Actor("Robert", "Downey Jr", "Comedy");
		Actor john4 = new Actor("Tommy", "Lee Jones", "Action");
		Actor john5 = new Actor("Dwayne", "Johnson", "Action");
	
		actorRepository.save(john1);
		actorRepository.save(john2);
		actorRepository.save(john3);
		actorRepository.save(john4);
		actorRepository.save(john5);
		
		List<Movie> movies = new LinkedList<>();
		movies.add(new Movie("Matrix", "Warner Bros.", "1999", Arrays.asList(john1)));
		movies.add(new Movie("Men In Black", "Sony Pictures", "1997", Arrays.asList(john2, john4)));
		movies.add(new Movie("Aladdin", "Disney", "2019", Arrays.asList(john2)));
		movies.add(new Movie("Men In Black2", "Sony Pictures", "2002", Arrays.asList(john2, john4)));
		movies.add(new Movie("Iron Man", "Marvel", "2008", Arrays.asList(john3)));
		movies.add(new Movie("Black Adam", "DC Films", "2022", Arrays.asList(john5)));
		
		movies.forEach(movie -> movieRepository.save(movie));
	}
}

