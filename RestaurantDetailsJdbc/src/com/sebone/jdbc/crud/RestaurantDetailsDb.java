package com.sebone.jdbc.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestaurantDetailsDb {
	static Connection con;
	public static Connection create() {
		
		ArrayList<RestaurantData> restaurantDetailsList=new ArrayList<>();
		try {
			String DB_URL="jdbc:mysql://localhost/local_restaurants";
			String User="root";
			String Pwd="Nish@123";
			con=DriverManager.getConnection(DB_URL,User,Pwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	
	}
}
