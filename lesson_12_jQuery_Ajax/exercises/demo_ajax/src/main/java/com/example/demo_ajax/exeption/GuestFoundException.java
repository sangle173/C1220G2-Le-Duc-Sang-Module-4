package com.example.demo_ajax.exeption;


public class GuestFoundException extends RuntimeException {
    private static final long serialVersionUID = -3845574518872003019L;

    public GuestFoundException() {
        super();
    }

    public GuestFoundException(String message) {
        super(message);
    }
}
