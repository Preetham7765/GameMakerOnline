package com.gamemaker.dao;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.gamemaker.entity.GameDetails;

@Repository
public class GameDetailsDao implements GameRepository{

	@Override
	public <S extends GameDetails> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends GameDetails> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<GameDetails> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<GameDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<GameDetails> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GameDetails entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends GameDetails> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
