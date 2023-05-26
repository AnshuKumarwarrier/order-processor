package com.planet.Exception;

public class OrderNotavailable extends RuntimeException{
	
	public OrderNotavailable() {
		
		super();
	}
	
public OrderNotavailable(String msg) {
		
		super(msg);
	}

}
