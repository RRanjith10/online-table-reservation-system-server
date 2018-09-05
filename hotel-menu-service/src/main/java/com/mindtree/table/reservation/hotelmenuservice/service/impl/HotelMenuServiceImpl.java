/**
 * 
 */
package com.mindtree.table.reservation.hotelmenuservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.hotelmenuservice.entity.HotelMenuType;
import com.mindtree.table.reservation.hotelmenuservice.entity.HotelTableType;
import com.mindtree.table.reservation.hotelmenuservice.repository.MenuRepository;
import com.mindtree.table.reservation.hotelmenuservice.repository.TableRepository;
import com.mindtree.table.reservation.hotelmenuservice.service.HotelMenuService;

/**
 * @author Ranjith Ranganathan
 *
 */
@Service
public class HotelMenuServiceImpl implements HotelMenuService {
	
	@Autowired
	MenuRepository menuRepository;
    @Autowired
    TableRepository tableRepository;

	@Override
	public List<HotelTableType> searchTablesByHotelId(String hId) {
		int hotelId = Integer.parseInt(hId);
        List<HotelTableType> tableList = tableRepository.findByHotelHid(hotelId);
        return tableList;
	}

	@Override
	public List<HotelMenuType> searchMenuByHotelId(String hId) {
		int hotelId = Integer.parseInt(hId);
        List<HotelMenuType> menuList = menuRepository.findByHotelHid(hotelId);
        return menuList;
	}

}
