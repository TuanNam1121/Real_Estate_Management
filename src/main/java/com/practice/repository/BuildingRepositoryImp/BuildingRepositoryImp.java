package com.practice.repository.BuildingRepositoryImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.repository.BuildingRepository;
import com.practice.repository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImp implements BuildingRepository{
	private static String url = "jdbc:mysql://localhost:3306/estatebasic";
	private static String userName = "root";
	private static String password = "admin";
	
	@Override
	public List<BuildingEntity> getAll() {
		List<BuildingEntity> res = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "SELECT * FROM Building";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BuildingEntity i = new BuildingEntity();
				i.setName(rs.getString("name"));
				i.setStreet(rs.getString("street"));
				i.setWard(rs.getString("ward"));
				i.setManagerName(rs.getString("managername"));
				i.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				i.setNumberOfBasement(rs.getInt("numberofbasement"));
				i.setFloorArea(rs.getInt("floorarea"));
				i.setRentPrice(rs.getDouble("rentprice"));
				res.add(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public List<BuildingEntity> findByName(String name) {
		List<BuildingEntity> res = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "Select * From Building where name like '%" + name + "%'";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BuildingEntity i = new BuildingEntity();
				i.setName(rs.getString("name"));
				i.setStreet(rs.getString("street"));
				i.setWard(rs.getString("ward"));
				i.setManagerName(rs.getString("managername"));
				i.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				i.setNumberOfBasement(rs.getInt("numberofbasement"));
				i.setFloorArea(rs.getInt("floorarea"));
				i.setRentPrice(rs.getDouble("rentprice"));
				res.add(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public List<BuildingEntity> findByRentPrice(Double price, boolean higher) {
		List<BuildingEntity> res = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "Select * From Building where rentprice ";
			String compare = (higher) ? "> " + price  : " < " + price;
			PreparedStatement stmt = conn.prepareStatement(query + compare);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BuildingEntity i = new BuildingEntity();
				i.setName(rs.getString("name"));
				i.setStreet(rs.getString("street"));
				i.setWard(rs.getString("ward"));
				i.setManagerName(rs.getString("managername"));
				i.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				i.setNumberOfBasement(rs.getInt("numberofbasement"));
				i.setFloorArea(rs.getInt("floorarea"));
				i.setRentPrice(rs.getDouble("rentprice"));
				res.add(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<BuildingEntity> findByFloorArea(Integer minFloorArea, Integer maxFloorArea) {
		List<BuildingEntity> res = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "Select * from building where rentprice in (" + minFloorArea + "," + maxFloorArea + ")";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BuildingEntity i = new BuildingEntity();
				i.setName(rs.getString("name"));
				i.setStreet(rs.getString("street"));
				i.setWard(rs.getString("ward"));
				i.setManagerName(rs.getString("managername"));
				i.setManagerPhoneNumber(rs.getString("managerphonenumber"));
				i.setNumberOfBasement(rs.getInt("numberofbasement"));
				i.setFloorArea(rs.getInt("floorarea"));
				i.setRentPrice(rs.getDouble("rentprice"));
				res.add(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean deleteById(String id) {
		if(id.isEmpty()) return false;
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String query = "delete from building where id = " + id;
			PreparedStatement stmt = conn.prepareStatement(query);
			return stmt.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
