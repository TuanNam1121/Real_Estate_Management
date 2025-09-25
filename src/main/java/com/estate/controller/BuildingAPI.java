package com.estate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.model.BuildingDTO;
import com.estate.service.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(name= "/buildings/")
	public List<BuildingDTO> getAll(){
		return buildingService.getAll();
	}
	
}
