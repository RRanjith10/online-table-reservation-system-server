package com.mindtree.table.reservation.customerservice.service;

import com.mindtree.table.reservation.customerservice.entity.Customer;

public interface CustomerRegistrationService {

    public Customer searchCustomer(String emailId);

    public Customer saveCustomer(Customer saveCust);

    public Customer validateUser(String emailId, String password);


}
