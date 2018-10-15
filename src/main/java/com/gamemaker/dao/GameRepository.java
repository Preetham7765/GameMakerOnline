package com.gamemaker.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamemaker.entity.GameDetails;

@Repository
public interface GameRepository extends CrudRepository<GameDetails, Integer>{

	@Query(value="select g.name from game_details g where g.id= :id", nativeQuery = true) 
	public String findNameById(@Param("id")int id);

	public GameDetails findByName(String game);

}
