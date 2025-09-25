package com.estate.service;

import java.util.List;
import java.util.Map;

import com.estate.model.BuildingDTO;

public interface BuildingService {
	public List<BuildingDTO> getAll();
	public List<BuildingDTO> find(Map<String, String> param);
}
