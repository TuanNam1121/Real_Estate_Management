package com.practice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.BuildingDTO;
import com.practice.services.BuildingServices;

import customException.MissingRequiredField;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingServices buildingServices;
	
	@GetMapping(value= "/api/buidings/")
	public List<BuildingDTO> getAllBuilding(){
		List<BuildingDTO> result = buildingServices.getAll();
		return result;
	}
	
	@GetMapping(value= "/api/buiding/name/")
	public List<BuildingDTO> findByName(@RequestParam(value= "name", required = true) String name){
		List<BuildingDTO> result = buildingServices.findByName(name);
		return result;
	}
	
	@GetMapping(value= "/api/building/price/")
	public List<BuildingDTO> findByRentPrice(@RequestParam Map<String, String> param){
		validateBoolean(param.get("higher"));
		boolean higher = (param.get("higher").equals("true")) ? true : false;
		Double price = Double.parseDouble(param.get("price"));
		List<BuildingDTO> result = buildingServices.findByRentPrice(price, higher);
		return result;
	}
	
	private void validateBoolean(String higher) {
		if(higher.isEmpty() || !(higher.equals("true") || higher.equals("false"))) {
			throw new MissingRequiredField("không nhận được giá trị higher");
		}
	}
	
	@GetMapping(value= "/api/building/floor")
	public List<BuildingDTO> findByFloorArea(@RequestParam(value= "minFloorArea") Integer minFloorArea,
											 @RequestParam(value= "maxFloorArea") Integer maxFloorArea){
		List<BuildingDTO> result = buildingServices.findByFloorArea(minFloorArea, maxFloorArea);
		return result;
	}
}
