package com.estate.repository;

import java.util.List;

import com.estate.repository.entity.BuildingEntity;

public interface BuildingRepository {
	public List<BuildingEntity> getAll();
}
