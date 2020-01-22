package com.abc.hospitalfrontdesk.dao;

import com.abc.hospitalfrontdesk.model.Hospital;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalDAOService {

    private static List<Hospital> hospitalsList;

    static {
        hospitalsList = new ArrayList<Hospital>();
        hospitalsList.add(new Hospital(1, "Chathura Pediatrics", 5));
        hospitalsList.add(new Hospital(2, "Heal Quickly", 20));
        hospitalsList.add(new Hospital(3, "Sunshine Hospitals", 48));
    }

    public List<Hospital> findAll() {
        return hospitalsList;
    }

    public Hospital findHospital(String hospitalName) {
        return hospitalsList.stream().filter(hospital -> hospital.getName().contentEquals(hospitalName)).findAny()
                .orElse(null);
    }
}
