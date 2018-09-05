package com.mindtree.table.reservation.hotelsearchservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.table.reservation.hotelsearchservice.model.HotelResponse;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="hotel-menu-service")
public interface HotelSearchServiceProxy {

	@GetMapping(value="/hotel-menu-service/getMenus/{hotelId}")
	public HotelResponse getMenuList(@PathVariable("hotelId") String hotelId);
}
