package com.estate.service.buildingServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estate.model.BuildingDTO;
import com.estate.repository.BuildingRepository;
import com.estate.repository.entity.BuildingEntity;
import com.estate.service.BuildingService;
@Service
public class BuildingServiceImp implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> getAll() {
		List<BuildingEntity> buildingList = buildingRepository.getAll();
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity i : buildingList) {
			BuildingDTO object = new BuildingDTO();
			object.setName(i.getName());
			object.setAddress(i.getStreet() + " ," + i.getWard());
			object.setNumberOfBasement(i.getNumberOfBasement());
			object.setManagerName(i.getManagerName());
			object.setManagerPhoneNumber(i.getManagerPhoneNumber());
			object.setFloorArea(i.getFloorArea());
			object.setRentPrice(i.getRentPrice());
			object.setServiceFee(i.getServiceFee());
			object.setBrokerageFee(i.getBrokerageFee());
			result.add(object);
		}
		return result;
	}
	
	@Override
	public List<BuildingDTO> find(Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
