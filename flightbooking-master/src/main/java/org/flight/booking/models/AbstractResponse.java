package org.flight.booking.models;

import org.flight.booking.common.Status;

public abstract class AbstractResponse {

    private Status status;
    private String message;

    public AbstractResponse(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public AbstractResponse() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
