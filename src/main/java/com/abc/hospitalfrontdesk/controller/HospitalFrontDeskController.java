package com.abc.hospitalfrontdesk.controller;

import com.abc.hospitalfrontdesk.dao.*;
import com.abc.hospitalfrontdesk.model.Appointment;
import com.abc.hospitalfrontdesk.model.Hospital;
import com.abc.hospitalfrontdesk.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalFrontDeskController {

    @Autowired
    private HospitalDAOService hospitalDAOService;

    @Autowired
    private SpecialistDAOService specialistDAOService;

    @GetMapping("/specialists/{hospitalName}/{specialistType}")
    public List<Specialist> getListOfSpecialists(@PathVariable String hospitalName,
                                                 @PathVariable String specialistType) {
        Hospital hospital = hospitalDAOService.findHospital(hospitalName);
        if (hospital == null) {
            throw new HospitalNotFoundException("hospital name - " + hospitalName);
        } else {
            List<Specialist> specialists = specialistDAOService.findSpecialist(hospital.getId(), specialistType);
            if (specialists == null || specialists.isEmpty()) {
                throw new SpecialistNotFound("specialist - " + specialistType);
            }
            return specialists;
        }
    }

    @GetMapping("/hospital/{hospitalName}")
    public String getNoOfBedsAvailable(@PathVariable String hospitalName) {
        Hospital hospital = hospitalDAOService.findHospital(hospitalName);
        if (hospital == null) {
            throw new HospitalNotFoundException("hospital name - " + hospitalName);
        } else {
            return "Number of Beds Available is = " + hospital.getBedsAvailable();
        }
    }

    @PostMapping("/hospital/appointment")
    public ResponseEntity<Object> makeAppointment(@RequestBody Appointment appointment) {
        Specialist specialist = specialistDAOService.findSpecialist(appointment.getSpecialistName());
        if (specialist == null) {
            throw new SpecialistNotFound("specialist - " + appointment.getSpecialistName());
        } else if (
                specialist.getAvailableDays().stream().filter(d -> d.equalsIgnoreCase(appointment.getAppointmentDay()))
                        .count() <= 0) {
            throw new SpecialistNotAvailable(" day - "+appointment.getAppointmentDay());
        } else {
            appointment.setAppointmentTime(specialist.getAvailableTime());
        }
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }
}
