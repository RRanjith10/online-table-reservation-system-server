package com.mindtree.table.reservation.hotelpaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelPaymentServiceApplication.class, args);
	}
}
