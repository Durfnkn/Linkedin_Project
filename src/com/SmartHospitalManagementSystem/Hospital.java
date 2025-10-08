package com.SmartHospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void registerPatient(Patient p) {
        patients.add(p);
        System.out.println("Patient registered: " + p.getName());
    }

    public void registerDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("Doctor registered: " + d.getName());
    }

    public synchronized void scheduleAppointment(String patientID, String doctorID, String slot)
            throws InvalidPatientIDException, InvalidDoctorIDException, SlotUnavailableException {

        // Validate patient
        Patient patient = null;
        for (Patient p : patients) {
            if (p.getPatientID().equals(patientID)) patient = p;
        }
        if (patient == null) throw new InvalidPatientIDException("Patient ID not found: " + patientID);

        // Validate doctor
        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.getDoctorID().equals(doctorID)) doctor = d;
        }
        if (doctor == null) throw new InvalidDoctorIDException("Doctor ID not found: " + doctorID);

        // Validate slot
        if (!doctor.isSlotAvailable(slot)) {
            throw new SlotUnavailableException("Slot " + slot + " is unavailable for Dr." + doctor.getName());
        }

        // Book slot and create appointment
        doctor.bookSlot(slot);
        Appointment app = new Appointment(patient, doctor, slot);
        appointments.add(app);
        System.out.println("Appointment scheduled successfully!");
    }

    public void viewAppointments() {
        System.out.println("\nAll Appointments:");
        for (Appointment app : appointments) {
            app.printDetails();
        }
    }
}
