package com.gamemaker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamemaker.entity.PlayerDetails;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDetails, Integer>{

}
