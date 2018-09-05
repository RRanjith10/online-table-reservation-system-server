package com.mindtree.table.reservation.hotelmenuservice.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.table.reservation.hotelmenuservice.model.MenuResponse;
import com.mindtree.table.reservation.hotelmenuservice.service.impl.HotelMenuServiceImpl;

@RestController
public class HotelMenuServiceController {
	@Autowired
	private HotelMenuServiceImpl menuService;

	@ApiOperation(value = "Retrieves the menu details and send",response = MenuResponse.class)
	@GetMapping(value="/getMenus/{hotelId}")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public MenuResponse getMenuList(@PathVariable("hotelId") String hotelId) {
		MenuResponse response = new MenuResponse();
		response.setTableList(menuService.searchTablesByHotelId(hotelId));
		response.setMenuList(menuService.searchMenuByHotelId(hotelId));
		return response;
	}
}
