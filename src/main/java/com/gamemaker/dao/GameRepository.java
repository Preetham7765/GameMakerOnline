package com.gamemaker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamemaker.entity.GameDetails;

@Repository
public interface GameRepository extends CrudRepository<GameDetails, Integer>{

}
