package com.abc.hospitalfrontdesk.dao;

import com.abc.hospitalfrontdesk.model.Specialist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecialistDAOService {

    private static List<Specialist> specialistList;

    static {
        specialistList = new ArrayList<Specialist>();
        specialistList.add(new Specialist("Pediatrician", "Chathura",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"), "9 to 5", Boolean.TRUE, 1));
        specialistList.add(new Specialist("Pediatrician", "Bhavesh", Arrays.asList("Tuesday", "Wednesday", "Thursday"),
                "10 to 11", Boolean.TRUE, 1));
        specialistList
                .add(new Specialist("Oncologist", "Advaith", Arrays.asList("Tuesday", "Thursday", "Saturday"), "9 to 5",
                        Boolean.TRUE, 1));
        specialistList.add(new Specialist("Pediatrician", "Chathura", Arrays.asList("Monday", "Wednesday", "Friday"),
                "9 to 5", Boolean.TRUE, 2));
        specialistList
                .add(new Specialist("Dentist", "Bhavesh", Arrays.asList("Monday", "Friday"), "9 to 5", Boolean.TRUE,
                        2));
        specialistList.add(new Specialist("Gynaecologist", "Chelsi",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"), "9 to 5", Boolean.TRUE, 2));
        specialistList.add(new Specialist("General Medicine", "Brahma",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"), "9 to 5", Boolean.TRUE, 3));
        specialistList.add(new Specialist("Cardiologist", "Nanda", Arrays.asList("Tuesday", "Wednesday", "Thursday"),
                "9 to 5", Boolean.TRUE, 3));
        specialistList
                .add(new Specialist("Oncologist", "Advaith", Arrays.asList("Monday", "Wednesday", "Friday"), "9 to 5",
                        Boolean.TRUE, 3));
        specialistList
                .add(new Specialist("Orthopedist", "Kakumanu", Arrays.asList("Monday", "Wednesday", "Friday"), "9 to 5",
                        Boolean.TRUE, 3));
    }

    public List<Specialist> findSpecialist(int hospitalId, String specialistType) {
        return specialistList.stream().filter(specialist -> specialist.getHospitalId() == hospitalId &&
                specialist.getType().equalsIgnoreCase(specialistType)).collect(Collectors.toList());
    }

    public Specialist findSpecialist(String specialistName) {
        return specialistList.stream().filter(specialist -> specialist.getName().equalsIgnoreCase(specialistName))
                .findAny().orElse(null);
    }
}
