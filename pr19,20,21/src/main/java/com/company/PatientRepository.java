package com.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllBy();
    List<Patient> findAllByPosition(String position);
}
