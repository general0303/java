package com.company;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class DoctorService {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DoctorRepository dr;

    @Autowired
    private PatientRepository pr;

    @Autowired
    private EmailService es;

    public String addNewDoctor(String name, String last_name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setLast_name(last_name);
        dr.save(doctor);
        log.info("Save doctor {}", doctor);
        es.sendEmailDoctor(doctor);
        return "ok";
    }

    public List<Doctor> show_doctors(){
        log.info("find all doctors");
        return dr.findAll();
    }
}
