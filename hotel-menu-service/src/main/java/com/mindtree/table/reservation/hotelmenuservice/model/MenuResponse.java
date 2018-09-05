package com.mindtree.table.reservation.hotelmenuservice.model;

import java.util.List;

import com.mindtree.table.reservation.hotelmenuservice.entity.HotelMenuType;
import com.mindtree.table.reservation.hotelmenuservice.entity.HotelTableType;

public class MenuResponse {

	private List<HotelTableType> tableList;

	private List<HotelMenuType> menuList;

	public List<HotelTableType> getTableList() {
		return tableList;
	}

	public void setTableList(List<HotelTableType> tableList) {
		this.tableList = tableList;
	}

	public List<HotelMenuType> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<HotelMenuType> menuList) {
		this.menuList = menuList;
	}
	
	
}
