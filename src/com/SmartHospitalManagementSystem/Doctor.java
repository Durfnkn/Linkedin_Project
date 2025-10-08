package com.SmartHospitalManagementSystem;



import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String doctorID;
    private String name;
    private String specialization;
    private List<String> availableSlots;

    public Doctor(String doctorID, String name, String specialization) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
        // Predefined slots for simplicity
        availableSlots.add("10:00");
        availableSlots.add("11:00");
        availableSlots.add("12:00");
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public boolean isSlotAvailable(String slot) {
        return availableSlots.contains(slot);
    }

    public void bookSlot(String slot) throws SlotUnavailableException {
        if (!availableSlots.contains(slot)) {
            throw new SlotUnavailableException("Slot " + slot + " is unavailable for " + name);
        }
        availableSlots.remove(slot);
        System.out.println("Appointment booked with Dr." + name + " at " + slot);
    }

    public void viewAvailableSlots() {
        System.out.println("Available slots for Dr." + name + ": " + availableSlots);
    }
}

