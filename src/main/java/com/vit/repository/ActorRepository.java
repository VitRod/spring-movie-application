package com.vit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vit.domain.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long>{

	public List<Actor> findByGenre(String genre);
}
