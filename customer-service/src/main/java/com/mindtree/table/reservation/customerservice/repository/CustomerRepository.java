package com.mindtree.table.reservation.customerservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.customerservice.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	public Customer findByEmailId(String emailId);

    public Customer save(Customer c);
}
