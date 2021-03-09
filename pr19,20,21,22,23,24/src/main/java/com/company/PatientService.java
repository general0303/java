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
public class PatientService {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DoctorRepository dr;

    @Autowired
    private PatientRepository pr;

    @Autowired
    private EmailService em;

    public String add_patient(String name, String last_name, String position, Integer doctor_id){
        Patient patient = new Patient();
        patient.setName(name);
        patient.setLast_name(last_name);
        patient.setPosition(position);
        patient.setDoctor(dr.getOne(doctor_id));
        pr.save(patient);
        em.sendEmailPatient(patient);
        log.info("Save doctor {}", patient);
        return "ok";
    }

    public List<Patient> show_patients(String position){
        log.info("find all patients, whose position = {}", position);
        return pr.findAllByPosition(position);
    }

    public List<Patient> show_patients(){
        log.info("find all patients");
        return pr.findAllBy();
    }
}
