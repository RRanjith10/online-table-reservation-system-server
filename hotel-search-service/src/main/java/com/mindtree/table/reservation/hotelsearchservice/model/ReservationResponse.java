package com.mindtree.table.reservation.hotelsearchservice.model;

public class ReservationResponse {
    
    private String message;
    
    private int totalAmount;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
