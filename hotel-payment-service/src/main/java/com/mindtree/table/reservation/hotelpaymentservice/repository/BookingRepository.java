package com.mindtree.table.reservation.hotelpaymentservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.hotelpaymentservice.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
    public Booking save(Booking book);
}
