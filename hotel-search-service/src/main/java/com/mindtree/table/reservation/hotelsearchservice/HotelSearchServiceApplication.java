package com.mindtree.table.reservation.hotelsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.mindtree.table.reservation.hotelsearchservice")
public class HotelSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSearchServiceApplication.class, args);
	}
}
