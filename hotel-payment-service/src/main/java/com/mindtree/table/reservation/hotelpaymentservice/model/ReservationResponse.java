package com.mindtree.table.reservation.hotelpaymentservice.model;

public class ReservationResponse {
    
    private String message;
    
    private int totalAmount;
    
    private boolean isPaymentSuccess;

    public boolean isPaymentSuccess() {
		return isPaymentSuccess;
	}

	public void setPaymentSuccess(boolean isPaymentSuccess) {
		this.isPaymentSuccess = isPaymentSuccess;
	}

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
