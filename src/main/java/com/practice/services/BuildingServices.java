package com.practice.services;

import java.util.List;

import com.practice.model.BuildingDTO;

public interface BuildingServices {
	public List<BuildingDTO> getAll();
	public List<BuildingDTO> findByName(String name);
	public List<BuildingDTO> findByRentPrice(Double price, boolean higher);
	public List<BuildingDTO> findByFloorArea(Integer minFloorArea, Integer maxFloorArea);
	public boolean deteleById(String id);
}
