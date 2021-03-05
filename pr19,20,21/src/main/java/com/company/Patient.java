package com.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String last_name;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @JsonIgnore
    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPosition() {
        return position;
    }
}
