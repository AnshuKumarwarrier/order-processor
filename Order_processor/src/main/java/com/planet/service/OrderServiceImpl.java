package com.planet.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.planet.model.Order;
import com.planet.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	 private static final Pattern CAMEROON_PATTERN = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");
	    private static final Pattern ETHIOPIA_PATTERN = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$");
	    private static final Pattern MOROCCO_PATTERN = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$");
	    private static final Pattern MOZAMBIQUE_PATTERN = Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$");
	    private static final Pattern UGANDA_PATTERN = Pattern.compile("\\(256\\)\\ ?\\d{9}$");

	    private final OrderRepository orderRepository;

	    @Autowired
	    public OrderServiceImpl(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }

	    @Override
	    public void importOrders(MultipartFile file) throws FileNotFoundException {
	        List<Order> orders = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] fields = line.split(",");

	                if (fields.length >= 4) {
	                	
	                    String email = fields[1].trim();
	                    String phoneNumber = fields[2].trim();
	                    String parcel_weight = fields[3].trim();
	                    
	                    String country = determineCountry(phoneNumber);

	                    Order order = new Order();
	                    order.setEmail(email);
	                    order.setPhoneNumber(phoneNumber);
	                    order.setParcel_weight(parcel_weight);
	                    // Set other order attributes
	                    order.setCountry(country);

	                    orders.add(order);
	                }
	            }

	            orderRepository.saveAll(orders);
	        } catch (IOException e) {
	            throw new FileNotFoundException("File not found...");
	        }
	    }

	    private String determineCountry(String phoneNumber) {
	        if (CAMEROON_PATTERN.matcher(phoneNumber).matches()) {
	            return "Cameroon";
	        } else if (ETHIOPIA_PATTERN.matcher(phoneNumber).matches()) {
	            return "Ethiopia";
	        } else if (MOROCCO_PATTERN.matcher(phoneNumber).matches()) {
	            return "Morocco";
	        } else if (MOZAMBIQUE_PATTERN.matcher(phoneNumber).matches()) {
	            return "Mozambique";
	        } else if (UGANDA_PATTERN.matcher(phoneNumber).matches()) {
	            return "Uganda";
	        } else {
	            return "Unknown";
	        }
	    }

		

		@Override
		public List<Order> getAllData() {
			// TODO Auto-generated method stub
			return orderRepository.findAll();
		}

		
		
	}