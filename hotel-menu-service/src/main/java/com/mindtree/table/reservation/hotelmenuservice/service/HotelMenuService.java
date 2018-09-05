package com.mindtree.table.reservation.hotelmenuservice.service;

import java.util.List;

import com.mindtree.table.reservation.hotelmenuservice.entity.HotelMenuType;
import com.mindtree.table.reservation.hotelmenuservice.entity.HotelTableType;

public interface HotelMenuService {

    public List<HotelTableType> searchTablesByHotelId(String hId);

    public List<HotelMenuType> searchMenuByHotelId(String hId);

}
