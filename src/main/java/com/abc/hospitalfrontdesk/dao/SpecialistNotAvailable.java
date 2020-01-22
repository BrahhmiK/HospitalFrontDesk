package com.abc.hospitalfrontdesk.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpecialistNotAvailable extends RuntimeException {
    public SpecialistNotAvailable(String message) {
        super(message);
    }
}
