package com.mindtree.table.reservation.hotelsearchservice.model;

import java.util.List;

import com.mindtree.table.reservation.hotelsearchservice.entity.HotelMenuType;
import com.mindtree.table.reservation.hotelsearchservice.entity.HotelTableType;
import com.mindtree.table.reservation.hotelsearchservice.entity.Hotels;

public class HotelResponse {

    private Hotels selectedHotel;
    
    private List<HotelTableType> tableList;
    
    private List<HotelMenuType> menuList;

    public Hotels getSelectedHotel() {
        return selectedHotel;
    }

    public void setSelectedHotel(Hotels selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

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
