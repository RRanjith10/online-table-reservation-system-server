package com.mindtree.table.reservation.hotelpaymentservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.table.reservation.hotelpaymentservice.model.BookingRequest;
import com.mindtree.table.reservation.hotelpaymentservice.model.ReservationResponse;
import com.mindtree.table.reservation.hotelpaymentservice.service.impl.EmailService;
import com.mindtree.table.reservation.hotelpaymentservice.service.impl.ReservationServiceImpl;


@RestController
public class HotelPaymentServiceController {
	
	@Autowired
    private ReservationServiceImpl reservationService;
    @Autowired
    private EmailService emailService;

    @ApiOperation(value = "Makes payment for the items purchased by the customer",response = ReservationResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Payment is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to make the payment"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Payment gateway is not found/unavailable")
    })
	@PostMapping(value="/pay")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public ReservationResponse makePayment (@RequestBody BookingRequest bookingRequest) {
        ReservationResponse response = new ReservationResponse();
        Long totalAmount = bookingRequest.getTotalAmount();
        boolean isPaymentSuccess = reservationService.processPayment(totalAmount, bookingRequest.getCardNumber(), bookingRequest.getCvv());
        if (isPaymentSuccess) {
            String bookeduserMailId = bookingRequest.getMailId();
            String bookedhname = bookingRequest.getHotelName();
            String bookedusertableSelected = bookingRequest.getTableSelected();
            int bookedpersonCount = bookingRequest.getNoOfPerson();
            String bookedUserName = bookingRequest.getUserName();
            List<String> menuSelected = bookingRequest.getMenuSelected();
            StringBuilder menusOrdered = new StringBuilder();
            for (String menu : menuSelected) {
                String[] menuDetails = menu.split("---");
                menusOrdered.append(menuDetails[0]).append(" ");
            }
            String bookedmenuSelected = menusOrdered.toString();
            reservationService.saveBooking(totalAmount, bookeduserMailId, bookedhname, bookedusertableSelected,
                bookedmenuSelected, bookedUserName, bookedpersonCount);
            try {
                emailService.sendEmail(totalAmount, bookeduserMailId, bookedUserName , bookedhname, bookedusertableSelected, bookedmenuSelected,
                    bookedpersonCount);
                response.setMessage("Booking details are emailed to the registered mail id!");
                response.setPaymentSuccess(true);
            }
            catch (Exception e) {
                response.setMessage("Error in sending email. Please try again later");
                response.setPaymentSuccess(false);
            }
        }
        else {
            response.setMessage("Payment Unsuccessful. Please enter valid card details");
            response.setPaymentSuccess(false);
        }
        return response;
    }
}
