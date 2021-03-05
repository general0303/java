package com.company;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@Slf4j
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DoctorService ds;

    @Autowired
    private PatientService ps;

    @RequestMapping(path="/home")
    public String task() {return "task";}

    @GetMapping(path = "/add_doctor")
    public @ResponseBody String addNewDoctor(@RequestParam String name, @RequestParam String last_name){
        return ds.addNewDoctor(name, last_name);
    }

    @GetMapping(path = "/add_patient")
    public @ResponseBody String addNewPatient(@RequestParam String name, @RequestParam String last_name, @RequestParam String position, @RequestParam Integer doctor_id){
        return ps.add_patient(name, last_name, position, doctor_id);
    }

    @GetMapping(path = "/doctors")
    public @ResponseBody
    List<Doctor> show_doctors(){
        return ds.show_doctors();
    }

    @GetMapping(path="/patients")
    public @ResponseBody
    List<Patient> show_patients(@RequestParam String position){
        return ps.show_patients(position);
    }
}
