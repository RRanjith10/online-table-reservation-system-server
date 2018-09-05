package com.mindtree.table.reservation.hotelsearchservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.hotelsearchservice.entity.Hotels;
import com.mindtree.table.reservation.hotelsearchservice.repository.HotelRepository;
import com.mindtree.table.reservation.hotelsearchservice.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotels> searchHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }

    @Override
    public Hotels searchHotelsById(String hId) {
        int hotelId = Integer.parseInt(hId);
        return hotelRepository.findByHid(hotelId);
    }

    @Override
    public List<String> fetchAllCitiesofHotels() {
        List<String> citiesList = new ArrayList<String>();
        List<Hotels> hotelsList = hotelRepository.findAll();
        for (Hotels hotel : hotelsList) {
            if (!citiesList.contains(hotel.getCity())) {
                citiesList.add(hotel.getCity());
            }
        }
        return citiesList;
    }

    @Override
    public int calculateTotalBillAmount(List<String> itemList) {
        int total = 0;
        for (String item : itemList) {
            String[] specificItem = item.split("---");
            List<String> specificItemm = Arrays.asList(specificItem);
            int itemPerRate = Integer.parseInt(specificItemm.get(1));
            int quantity = Integer.parseInt(specificItemm.get(2));
            total = total + (itemPerRate * quantity);
        }
        return total;
    }
}
