package com.abc.hospitalfrontdesk.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpecialistNotFound extends RuntimeException {
    public SpecialistNotFound(String message) {
        super(message);
    }
}