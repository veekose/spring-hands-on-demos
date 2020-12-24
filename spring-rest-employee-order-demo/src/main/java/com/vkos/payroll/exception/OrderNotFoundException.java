package com.vkos.payroll.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Count not find employee: " + id);
    }
}