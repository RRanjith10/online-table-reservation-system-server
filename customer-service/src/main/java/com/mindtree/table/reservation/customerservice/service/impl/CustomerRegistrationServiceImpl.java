package com.mindtree.table.reservation.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.customerservice.entity.Customer;
import com.mindtree.table.reservation.customerservice.repository.CustomerRepository;
import com.mindtree.table.reservation.customerservice.service.CustomerRegistrationService;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{

    @Autowired
    CustomerRepository customerRepository;
    
    @Override
    public Customer searchCustomer(String emailId) {
        return customerRepository.findByEmailId(emailId);
    }
    
    @Override
    public Customer saveCustomer(Customer saveCust) {
        return customerRepository.save(saveCust);
    }

    @Override
    public Customer validateUser(String emailId, String password) {
        Customer loginCust = customerRepository.findByEmailId(emailId);
        if (loginCust != null && loginCust.getEmailId().equals(emailId) && loginCust.getPassword().equals(password)) {
            return loginCust;
        }
        return null;
    }
}
