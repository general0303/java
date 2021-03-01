package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private DoctorRepository dr;

    @Autowired
    private PatientRepository pr;

    @RequestMapping(path="/home")
    public String task() {return "task";}

    @GetMapping(path = "/add_doctor")
    public @ResponseBody String addNewDoctor(@RequestParam String name, @RequestParam String last_name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setLast_name(last_name);
        dr.save(doctor);
        return "ok";
    }

    @GetMapping(path = "/add_patient")
    public @ResponseBody String addNewPatient(@RequestParam String name, @RequestParam String last_name, @RequestParam String position, @RequestParam Integer doctor_id){
        Patient patient = new Patient();
        patient.setName(name);
        patient.setLast_name(last_name);
        patient.setPosition(position);
        patient.setDoctor(dr.getOne(doctor_id));
        pr.save(patient);
        return "ok";
    }

    @GetMapping(path = "/doctors")
    public @ResponseBody
    List<Doctor> show_doctors(){
        return dr.findAll();
    }

    @GetMapping(path="/patients")
    public @ResponseBody
    List<Patient> show_patients(@RequestParam String position){
        return pr.findAllByPosition(position);
    }
}
