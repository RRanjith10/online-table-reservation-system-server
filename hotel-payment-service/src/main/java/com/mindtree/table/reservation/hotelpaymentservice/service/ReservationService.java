package com.mindtree.table.reservation.hotelpaymentservice.service;


public interface ReservationService {

    public boolean processPayment(Long billTotal, String cardNo, String cvv);

    public boolean saveBooking(Long billTotal, String bookeduserMailId, String bookedhname,
        String bookedusertableSelected, String bookedmenuSelected, String bookedUserName, int bookedpersonCount);

}
