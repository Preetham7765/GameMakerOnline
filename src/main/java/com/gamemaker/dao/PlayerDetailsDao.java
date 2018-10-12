package com.gamemaker.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gamemaker.entity.PlayerDetails;

@Repository
public class PlayerDetailsDao implements PlayerRepository{

	@Override
	public <S extends PlayerDetails> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlayerDetails> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PlayerDetails> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<PlayerDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PlayerDetails> findAllById(Iterable<Integer> ids) {
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
	public void delete(PlayerDetails entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends PlayerDetails> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
