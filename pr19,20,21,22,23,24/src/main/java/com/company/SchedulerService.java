package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SchedulerService  {
    private static String doctorFile = "directory\\doctor.txt";
    private static String patientFile = "directory\\patient.txt";
    @Autowired
    private  DoctorService ds;

    @Autowired
    private PatientService ps;


    @Scheduled(cron = "0 */30 * * * *")
    @ManagedOperation
    public void updateFile() {

        for (File myFile : Objects.requireNonNull(new File("directory").listFiles())) {
            if (myFile.isFile()) myFile.delete();
        }

        try {
            File doctor = new File(doctorFile);
            File patient = new File(patientFile);
            doctor.createNewFile();
            patient.createNewFile();
            FileWriter fw1 = new FileWriter(doctor);
            FileWriter fw2 = new FileWriter(patient);
            fw1.write(ds.show_doctors().toString());
            fw2.write(ps.show_patients().toString());
            fw1.flush();
            fw2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
