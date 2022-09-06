package com.example.sbemintic.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Exception extends RuntimeException{

    private int statusCode;
    private String message;
    private Date transactionDate;

    public Exception(String message, int statusCode,Date transactionDate) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.transactionDate = transactionDate;
    }
}
