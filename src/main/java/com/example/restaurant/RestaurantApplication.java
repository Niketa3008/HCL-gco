package com.example.restaurant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestaurantApplication {
    
	@GetMapping("/")
	public String welcome() {
		return "Welcome All";
	}
	
	@GetMapping("/restaurant")
	@ResponseBody
	public Map<String, HashMap<String, Integer>> fetchRestaurant(){
		
		HashMap<String, Integer> menu1 = new HashMap<String, Integer>();
		menu1.put("Burger", 100);
		menu1.put("Fries", 50);
		menu1.put("Meal", 200);
			
		HashMap<String, Integer> menu2 = new HashMap<String, Integer>();
		menu2.put("Dal Makhani", 200);
		menu2.put("Paneer Makhani", 300);
		menu2.put("Roti", 20);

		HashMap<String, Integer> menu3 = new HashMap<String, Integer>();
		menu3.put("Cold Coffee", 150);
		menu3.put("Hot Coffee", 100);
		menu3.put("Sandwitch", 100);		
			
		Map<String, HashMap<String, Integer>> restaurant = new HashMap<String, HashMap<String, Integer>>();
		restaurant.put("MCDonalds", menu1);
		restaurant.put("IndianVeggieDelight", menu2);
		restaurant.put("JohnsCafe", menu3);
		return restaurant;
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
