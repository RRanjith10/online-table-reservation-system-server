package com.mindtree.table.reservation.hotelmenuservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.hotelmenuservice.entity.HotelMenuType;

public interface MenuRepository extends CrudRepository<HotelMenuType, Integer> {
	
    List<HotelMenuType> findByHotelHid(int hid);

}
