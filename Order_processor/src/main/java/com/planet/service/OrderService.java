package com.planet.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.planet.model.Order;

public interface OrderService {
	void importOrders(MultipartFile file) throws FileNotFoundException;


	List<Order> getAllData();

}
