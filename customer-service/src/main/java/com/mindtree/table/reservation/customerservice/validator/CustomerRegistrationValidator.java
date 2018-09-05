package com.mindtree.table.reservation.customerservice.validator;

import com.mindtree.table.reservation.customerservice.model.RegisterRequest;
import com.mindtree.table.reservation.customerservice.model.RegisterResponse;

public class CustomerRegistrationValidator {

	public boolean validateRegisterRequest(final RegisterRequest request,
			final RegisterResponse response) {
		boolean isValidRequest = true;
		if (request.getEmailId() == null || (request.getEmailId() != null
        		&& request.getEmailId().isEmpty())) {
        	response.setMessage("Email cannot be empty");
            response.setRegisterSuccess(false);
            isValidRequest = false;
        }
        else if (request.getPassword() == null || (request.getPassword() != null
        		&& request.getPassword().isEmpty())) {
        	response.setMessage("Password cannot be empty");
            response.setRegisterSuccess(false);
            isValidRequest = false;
        }
        else if (request.getCustName() == null || (request.getCustName() != null
        		&& request.getCustName().isEmpty())) {
        	response.setMessage("Name cannot be empty");
            response.setRegisterSuccess(false);
            isValidRequest = false;
        }
        else if (request.getCustName() == null || (request.getCustName() != null
        		&& request.getCustName().isEmpty())) {
        	response.setMessage("Name cannot be empty");
            response.setRegisterSuccess(false);
            isValidRequest = false;
        }
		return isValidRequest;
	}
}
