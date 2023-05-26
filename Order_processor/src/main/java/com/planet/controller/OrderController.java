package com.planet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.planet.Exception.FilenotsavedException;
import com.planet.Exception.OrderNotavailable;
import com.planet.model.Order;
import com.planet.service.OrderService;


import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class OrderController {
	   private final OrderService orderService;

	    @Autowired
	    public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

	    @PostMapping("/orders/import")
	    public ResponseEntity<String> importOrders(@RequestParam("file") MultipartFile file) {
	        try {
	            orderService.importOrders(file);
	            return ResponseEntity.ok("Orders imported successfully.");
	        } catch (Exception e) {
	        	
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error importing orders.");
	        	
	        	
	        }
	    }
	    
	    @GetMapping("/Order")
		public ResponseEntity<List<Order>> getData(){
			
			List<Order> li = new ArrayList<>();
				li=	orderService.getAllData();
				
				if(li.isEmpty()) {
					throw new OrderNotavailable(" Order is not available in DATABASE ");
				}
				
		return new ResponseEntity<List<Order>>(li,HttpStatus.OK);
				
		}
		
	   
	    
	}