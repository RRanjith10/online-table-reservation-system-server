package com.mindtree.table.reservation.hotelsearchservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.table.reservation.hotelsearchservice.entity.Hotels;
import com.mindtree.table.reservation.hotelsearchservice.model.HotelListResponse;
import com.mindtree.table.reservation.hotelsearchservice.model.HotelResponse;
import com.mindtree.table.reservation.hotelsearchservice.model.ReservationRequest;
import com.mindtree.table.reservation.hotelsearchservice.model.ReservationResponse;
import com.mindtree.table.reservation.hotelsearchservice.proxy.HotelSearchServiceProxy;
import com.mindtree.table.reservation.hotelsearchservice.service.impl.ReservationServiceImpl;

@RestController
public class HotelSearchServiceController {
	@Autowired
    private ReservationServiceImpl reservationService;
	@Autowired
	private HotelSearchServiceProxy proxy;

	@ApiOperation(value = "Performs Search of all the cities available in the system",response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized to access the system"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Online Table Reservation is not found/unavailable")
    })
	@GetMapping(value = "/getHotels", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<String> getHotels() {
        return reservationService.fetchAllCitiesofHotels();
    }
    
	@ApiOperation(value = "Searches all the hotels present in the selected city",response = HotelListResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Hotel search is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to search the hotels"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Search results are not found/unavailable")
    })
    @GetMapping(value = "/searchHotels/{cityName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    @CrossOrigin(origins = "*")
    public HotelListResponse searchHotels(@PathVariable("cityName") String cityName) {
        HotelListResponse response = new HotelListResponse();
        List<Hotels> hotelList = reservationService.searchHotelsByCity(cityName);
        if (hotelList.isEmpty()) {
            response.setMessage("No Hotels found in the selected city. Please select another city.");
        }
        response.setHotelList(hotelList);
        return response;
    }

	@ApiOperation(value = "Retrieves all the menu items and table list in the selected city",response = HotelResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Hotel search is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to search the hotels"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Search results are not found/unavailable")
    })
    @GetMapping(value="/viewHotel/{hotelId}")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public HotelResponse viewHotel(@PathVariable("hotelId") String hotelId) {
        HotelResponse response = new HotelResponse();
        Hotels selectedHotel = reservationService.searchHotelsById(hotelId);
        /*List<HotelTableType> tableList = reservationService.searchTablesByHotelId(hotelId);
        List<HotelMenuType> menuList = reservationService.searchMenuByHotelId(hotelId);*/
        HotelResponse menuList = proxy.getMenuList(hotelId);
        response.setMenuList(menuList.getMenuList());
        response.setSelectedHotel(selectedHotel);
        response.setTableList(menuList.getTableList());
        return response;
    }
    
    @PostMapping(value="/reserveTable")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public ReservationResponse placeReservation(@RequestBody ReservationRequest request) {
        ReservationResponse response = new ReservationResponse();
        response.setTotalAmount(reservationService.calculateTotalBillAmount(request.getMenuDetails()));
        return response;
    }
}
