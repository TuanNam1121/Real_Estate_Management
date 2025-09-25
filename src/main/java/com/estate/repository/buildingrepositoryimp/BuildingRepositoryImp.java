package com.estate.repository.buildingrepositoryimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.estate.repository.BuildingRepository;
import com.estate.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImp implements BuildingRepository{
	// jdbc mysql
	private static String url = "jdbc:mysql://localhost:3306/estatebasic";
	private static String userName = "root";
	private static String password = "admin";
	
	// Common
	private String getAllOfBuildingExist = "SELECT * FROM Building ORDER BY name asc";
	
	@Override
	public List<BuildingEntity> getAll() {
		List<BuildingEntity> result = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = getAllOfBuildingExist;
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setDirection(rs.getString("direction"));
				building.setLevel(rs.getString("level"));
				building.setRentPrice(rs.getInt("rentPrice"));
				building.setServiceFee(rs.getString("servicefee"));
				building.setCarFee(rs.getString("carFee"));
				building.setMotorbikeFee(rs.getString("motorbikefee"));
				building.setWaterFee(rs.getString("waterfee"));
				building.setElectricityFee(rs.getString("electricityfee"));
				building.setDeposit(rs.getString("deposit"));
				building.setPayment(rs.getString("payment"));
				building.setRentTime(rs.getString("renttime"));
				building.setDecorationTime(rs.getString("decorationtime"));
				building.setBrokerageFee(rs.getString("brokeragefee"));
				building.setNote(rs.getString("note"));
				building.setLinkOfBuilding(rs.getString("linkofbuilding"));
				building.setMap(rs.getString("map"));
				building.setImage(rs.getString("image"));
				if(rs.getTimestamp("createddate") != null)
					building.setCreatedDate(rs.getTimestamp("createddate").toLocalDateTime());
				building.setManagerName(rs.getString("managername"));
				building.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				result.add(building);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
