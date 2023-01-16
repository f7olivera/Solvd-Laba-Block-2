package com.solvd.buildingcompany.models.exceptions;

public class NegativeAmountException extends Exception {
    public NegativeAmountException(String errorMessage) {
        super(errorMessage);
    }

    public NegativeAmountException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
