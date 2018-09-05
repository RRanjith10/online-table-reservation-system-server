package com.mindtree.table.reservation.hotelmenuservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.hotelmenuservice.entity.HotelTableType;

public interface TableRepository extends CrudRepository<HotelTableType, Integer> {
	
    List<HotelTableType> findByHotelHid(int hid);

}
