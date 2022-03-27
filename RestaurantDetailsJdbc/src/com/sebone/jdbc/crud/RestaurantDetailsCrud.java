package com.sebone.jdbc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
public class RestaurantDetailsCrud {
	public ArrayList<RestaurantData> getRestaurantDetails(){
		ArrayList<RestaurantData>restaurantDetailsList=new ArrayList<>();
		try {
			Connection con=RestaurantDetailsDb.create();
			Statement start=con.createStatement();
			ResultSet rs=start.executeQuery("select * from restaurants_details");
			while(rs.next()) {
				RestaurantData restaurantData=new RestaurantData();
				restaurantData.setRestaurantId(rs.getInt("restaurants_id"));
				restaurantData.setRestaurantName(rs.getString("restaurants_name"));
				restaurantData.setRestaurantEmail(rs.getString("restaurants_email"));
				restaurantData.setRestaurantContact(rs.getLong("restaurants_contact"));
				restaurantData.setRestaurantType(rs.getString("restaurants_type"));
				restaurantData.setRestaurantStatus(rs.getString("restaurants_status"));
				restaurantData.setRestaurantDescription(rs.getString("restaurants_description"));
				restaurantData.setRestaurantAvgPrice(rs.getInt("restaurants_avg_price"));
				restaurantData.setRestaurantImage(rs.getString("restaurants_image"));
				restaurantDetailsList.add(restaurantData);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return restaurantDetailsList;	
	}
	public boolean createRestaurantDetails(RestaurantData restaurantDetails) {
		boolean isSuccess=false;
		try {
			Connection con=RestaurantDetailsDb.create();
			String query="insert into restaurants_details(restaurants_id,restaurants_name,restaurants_email,restaurants_contact,restaurants_type,restaurants_status,restaurants_description,restaurants_avg_price,restaurants_image) value(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1, restaurantDetails.getRestaurantId());
			preparedStatement.setString(2,restaurantDetails.getRestaurantName());
			preparedStatement.setString(3, restaurantDetails.getRestaurantEmail());
			preparedStatement.setLong(4, restaurantDetails.getRestaurantContact());
			preparedStatement.setString(5, restaurantDetails.getRestaurantType());
			preparedStatement.setString(6, restaurantDetails.getRestaurantStatus());
			preparedStatement.setString(7,restaurantDetails.getRestaurantDescription());
			preparedStatement.setInt(8, restaurantDetails.getRestaurantAvgPrice());
			preparedStatement.setString(9, restaurantDetails.getRestaurantImage());
			preparedStatement.executeUpdate();
			isSuccess=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean deleteRestaurantDetails(int id) {
		boolean isSuccess=false;
		try {
				Connection con=RestaurantDetailsDb.create();
				String query="delete from restaurants_details where restaurants_id=?";
				PreparedStatement prepareStatement=con.prepareStatement(query);
				prepareStatement.setInt(1, id);
				prepareStatement.executeUpdate();
				isSuccess=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean upadateRestaurantDetails(String name,int id) {
		boolean isSuccess=false;
		try {
				Connection con=RestaurantDetailsDb.create();
				String query="update restaurants_details Set restaurants_name=? where restaurants_id=?";
				PreparedStatement prepareStatement=con.prepareStatement(query);
				prepareStatement.setString(1, name);
				prepareStatement.setInt(2, id);
				prepareStatement.executeUpdate();
				isSuccess=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
