package com.gamemaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamemaker.entity.PlayerDetails;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDetails, Integer>{

	@Query(value ="select * from player_details p1 "
				   + "where p1.game_id in "
				   + "(select game_id from player_details group by game_id) "
				   + "order by p1.score asc limit 5;",
			nativeQuery = true)
	public List<PlayerDetails> getTopFiveScore();
}
