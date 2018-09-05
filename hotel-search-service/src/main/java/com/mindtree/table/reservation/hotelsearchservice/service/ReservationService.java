package com.mindtree.table.reservation.hotelsearchservice.service;

import java.util.List;

import com.mindtree.table.reservation.hotelsearchservice.entity.HotelMenuType;
import com.mindtree.table.reservation.hotelsearchservice.entity.HotelTableType;
import com.mindtree.table.reservation.hotelsearchservice.entity.Hotels;

public interface ReservationService {

    public List<Hotels> searchHotelsByCity(String city);

    public Hotels searchHotelsById(String hId);

    public List<String> fetchAllCitiesofHotels();

    public int calculateTotalBillAmount(List<String> itemList);
}
