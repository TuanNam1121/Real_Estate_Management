package com.practice.repository;

import java.util.List;

import com.practice.repository.Entity.BuildingEntity;

public interface BuildingRepository {
	// GET
	public List<BuildingEntity> getAll();
	public List<BuildingEntity> findByName(String name);
	public List<BuildingEntity> findByRentPrice(Double price, boolean higher);
	public List<BuildingEntity> findByFloorArea(Integer minFloorArea, Integer maxFloorArea);
	
	// DELETE
	public boolean deleteById(String id);
	
}
