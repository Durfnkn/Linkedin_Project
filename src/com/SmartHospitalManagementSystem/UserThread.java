package com.SmartHospitalManagementSystem;



public class UserThread implements Runnable {
    private Hospital hospital;
    private String patientID;
    private String doctorID;
    private String slot;

    public UserThread(Hospital hospital, String patientID, String doctorID, String slot) {
        this.hospital = hospital;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.slot = slot;
    }

    @Override
    public void run() {
        try {
            hospital.scheduleAppointment(patientID, doctorID, slot);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

