package com.sebone.jdbc.crud;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantDetails {

	public static void main(String[] args) {
		RestaurantDetailsCrud restaurantDetailsCrud=new RestaurantDetailsCrud();
		System.out.println(" Type 1 for read restaurants details \n Type 2 for create restaurants details  \n type 3 for delete restaurant details \n type 4 for update name");
		Scanner scanner=new Scanner(System.in);
		int userChoise=scanner.nextInt();
		if(userChoise==1) {
		ArrayList<RestaurantData> resArrayList= restaurantDetailsCrud.getRestaurantDetails();
		for(RestaurantData resDetails:resArrayList) {
			System.out.println("resDetails id "+resDetails.getRestaurantId());
		}
		}else if(userChoise==2) {
			System.out.println("type id");
			int id=scanner.nextInt();
			System.out.println("type name");
			scanner.nextLine();
			String name=scanner.nextLine();
			System.out.println("type email");
			String email=scanner.nextLine();
			System.out.println("type contact");
			Long contact=scanner.nextLong();
			scanner.nextLine();
			System.out.println("type type");
			String type=scanner.nextLine();
			System.out.println("type status");
			String status=scanner.nextLine();
			System.out.println("type description");
			String description=scanner.nextLine();
			System.out.println("type average price");
			int averagePrice=scanner.nextInt();
			scanner.nextLine();
			System.out.println("type image url");
			String image=scanner.nextLine();
			RestaurantData restaurantData=new RestaurantData();
			restaurantData.setRestaurantId(id);
			restaurantData.setRestaurantName(name);
			restaurantData.setRestaurantEmail(email);
			restaurantData.setRestaurantContact(contact);
			restaurantData.setRestaurantType(type);
			restaurantData.setRestaurantStatus(status);
			restaurantData.setRestaurantDescription(description);
			restaurantData.setRestaurantAvgPrice(averagePrice);
			restaurantData.setRestaurantImage(image);
			boolean  isSuccess=restaurantDetailsCrud.createRestaurantDetails(restaurantData);
			if(isSuccess) {
				System.out.println("restaurant details added");
			}else {
				System.out.println("some error");
			}
		}else if(userChoise==3) {
			System.out.println("type id of restaurant which you want to delete");
			int id=scanner.nextInt();
			boolean isSuccess= restaurantDetailsCrud.deleteRestaurantDetails(id);
			if(isSuccess) {
				System.out.println("restaurant details deleted");
			}else {
				System.out.println("some error");
			}
		}else if(userChoise==4) {
			System.out.println("type restaurant name and id which you want to update");
			int id=scanner.nextInt();
			scanner.nextLine();
			String name=scanner.nextLine();
			boolean isSuccess=restaurantDetailsCrud.upadateRestaurantDetails(name, id);
			if(isSuccess) {
				System.out.println("restaurant name updated");
			}else {
				System.out.println("some error");
			}
		}
	}

}
