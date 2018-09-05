package com.mindtree.table.reservation.customerservice.model;

public class RegisterResponse {
    
    private String message;
    
    private boolean isRegisterSuccess;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public void setRegisterSuccess(boolean isRegisterSuccess) {
        this.isRegisterSuccess = isRegisterSuccess;
    }
}
