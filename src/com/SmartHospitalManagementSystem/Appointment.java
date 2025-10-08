package com.SmartHospitalManagementSystem;


public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String slot;

    public Appointment(Patient patient, Doctor doctor, String slot) {
        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
    }

    public void printDetails() {
        System.out.println("Appointment: " + patient.getName() + " with Dr." + doctor.getName() + " at " + slot);
    }
}

