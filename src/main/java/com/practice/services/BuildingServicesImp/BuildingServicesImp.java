package com.practice.services.BuildingServicesImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.BuildingDTO;
import com.practice.repository.BuildingRepository;
import com.practice.repository.Entity.BuildingEntity;
import com.practice.services.BuildingServices;

@Service
public class BuildingServicesImp implements BuildingServices {
	
	@Autowired
	private BuildingRepository buildingrepo;
	
	@Override
	public List<BuildingDTO> getAll(){
		List<BuildingDTO> res = new ArrayList<>();
		try {
			List<BuildingEntity> buildingSet = buildingrepo.getAll();
			for(BuildingEntity i : buildingSet) {
				BuildingDTO record = new BuildingDTO();
				record.setName(i.getName());
				record.setNumberOfBasement(i.getNumberOfBasement());
				record.setStreet(i.getStreet());
				record.setWard(i.getWard());
				res.add(record);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public void handleSQLException(SQLException ex) throws SQLException {
		throw new SQLException(ex.getMessage());
	}


	@Override
	public List<BuildingDTO> findByName(String name) {
		List<BuildingDTO> res = new ArrayList<>();
		try {
			List<BuildingEntity> buildingSet = buildingrepo.findByName(name);
			for(BuildingEntity i : buildingSet) {
				BuildingDTO record = new BuildingDTO();
				record.setName(i.getName());
				record.setNumberOfBasement(i.getNumberOfBasement());
				record.setStreet(i.getStreet());
				record.setWard(i.getWard());
				res.add(record);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public List<BuildingDTO> findByRentPrice(Double price, boolean higher) {
		List<BuildingDTO> res = new ArrayList<>();
		try {
			List<BuildingEntity> buildingSet = buildingrepo.findByRentPrice(price, higher);
			for(BuildingEntity i : buildingSet) {
				BuildingDTO record = new BuildingDTO();
				record.setName(i.getName());
				record.setNumberOfBasement(i.getNumberOfBasement());
				record.setStreet(i.getStreet());
				record.setWard(i.getWard());
				record.setRentalPrice(i.getRentPrice());
				res.add(record);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public List<BuildingDTO> findByFloorArea(Integer minFloorArea, Integer maxFloorArea) {
		List<BuildingDTO> res = new ArrayList<>();
		try {
			List<BuildingEntity> buildingSet = buildingrepo.findByFloorArea(minFloorArea, maxFloorArea);
			for(BuildingEntity i : buildingSet) {
				BuildingDTO record = new BuildingDTO();
				record.setName(i.getName());
				record.setNumberOfBasement(i.getNumberOfBasement());
				record.setStreet(i.getStreet());
				record.setWard(i.getWard());
				res.add(record);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deteleById(String id) {
		if(id.isEmpty()) return false;
		return true;
	}

}
