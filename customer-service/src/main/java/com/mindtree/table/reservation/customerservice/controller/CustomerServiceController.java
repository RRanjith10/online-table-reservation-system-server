package com.mindtree.table.reservation.customerservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.table.reservation.customerservice.entity.Customer;
import com.mindtree.table.reservation.customerservice.model.LoginResponse;
import com.mindtree.table.reservation.customerservice.model.RegisterRequest;
import com.mindtree.table.reservation.customerservice.model.RegisterResponse;
import com.mindtree.table.reservation.customerservice.service.impl.CustomerRegistrationServiceImpl;
import com.mindtree.table.reservation.customerservice.validator.CustomerRegistrationValidator;

@RestController
public class CustomerServiceController {

	@Autowired
	private CustomerRegistrationServiceImpl customerRegistrationService;

	@ApiOperation(value = "To perform validation with the enterred user credentials",response = LoginResponse.class)
	@PostMapping(value = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@CrossOrigin(origins = "*")
	public LoginResponse validateUser(@RequestBody Customer user) {
		Customer customer = customerRegistrationService.validateUser(
				user.getEmailId(), user.getPassword());
		LoginResponse response = new LoginResponse();
		if (customer != null) {
			response.setLoginSuccessful(true);
			response.setEmail(customer.getEmailId());
			response.setUsername(customer.getCustName());
		} else {
			response.setLoginSuccessful(false);
			response.setMessage("Invalid username/password");
		}
		return response;
	}

	@ApiOperation(value = "Registers the user in the system",response = RegisterResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "User created Successfully"),
        @ApiResponse(code = 401, message = "You are not authorized to create a new user"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "User registerion is not found/unavailable")
    })
	@PostMapping(value = "/register")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public RegisterResponse registerUser(
			@RequestBody @Valid RegisterRequest request, BindingResult result) {
		RegisterResponse response = new RegisterResponse();
		CustomerRegistrationValidator validator = new CustomerRegistrationValidator();
		boolean isValidRequest = validator.validateRegisterRequest(request,
				response);
		if (isValidRequest) {
			Customer reqCustomer = new Customer(request.getEmailId(),
					request.getPassword(), request.getCustName(),
					request.getPhoneNo());
			Customer searchCustomer = customerRegistrationService
					.searchCustomer(request.getEmailId());
			if (searchCustomer == null) {
				customerRegistrationService.saveCustomer(reqCustomer);
				response.setMessage("Registration successful");
				response.setRegisterSuccess(true);
			} else {
				response.setMessage("Email already exists.");
				response.setRegisterSuccess(false);
			}
		}
		return response;
	}
}
