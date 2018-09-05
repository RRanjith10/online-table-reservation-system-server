package com.mindtree.table.reservation.hotelpaymentservice.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.hotelpaymentservice.entity.Booking;
import com.mindtree.table.reservation.hotelpaymentservice.entity.Customer;
import com.mindtree.table.reservation.hotelpaymentservice.entity.Hotels;
import com.mindtree.table.reservation.hotelpaymentservice.repository.BookingRepository;
import com.mindtree.table.reservation.hotelpaymentservice.repository.CustomerRepository;
import com.mindtree.table.reservation.hotelpaymentservice.repository.HotelRepository;
import com.mindtree.table.reservation.hotelpaymentservice.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    
    @Override
    public boolean processPayment(Long billTotal, String cardNo, String cvv) {
        if (cardNo != null && cardNo.length() == 16 && cvv.length() == 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean saveBooking(Long billTotal, String bookeduserMailId, String bookedhname,
        String bookedusertableSelected, String bookedmenuSelected, String bookedUserName, int bookedpersonCount) {
        Customer cust = customerRepository.findByEmailId(bookeduserMailId);
        List<Hotels> hotel = hotelRepository.findByHname(bookedhname);
        Booking booking = new Booking();
        booking.setBookingId(1);
        booking.setBillTotal(billTotal);
        booking.setBookedDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        booking.setCustomer(cust);
        booking.setHotel(hotel.get(0));
        cust.getCustName();
        bookingRepository.save(booking);
        return true;
    }
}
