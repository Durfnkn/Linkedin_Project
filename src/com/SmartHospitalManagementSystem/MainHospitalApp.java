package com.SmartHospitalManagementSystem;

import java.util.Scanner;

public class MainHospitalApp {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner sc = new Scanner(System.in);

        // Register doctors
        Doctor d1 = new Doctor("D001", "Smith", "Cardiology");
        Doctor d2 = new Doctor("D002", "Johnson", "Neurology");
        hospital.registerDoctor(d1);
        hospital.registerDoctor(d2);

        // Register patients
        Patient p1 = new Patient("P001", "Alice", 30);
        Patient p2 = new Patient("P002", "Bob", 40);
        hospital.registerPatient(p1);
        hospital.registerPatient(p2);

        System.out.println("\n=== Schedule an Appointment ===");
        System.out.print("Enter Patient ID: ");
        String patientID = sc.nextLine();

        System.out.print("Enter Doctor ID: ");
        String doctorID = sc.nextLine();

        System.out.print("Enter Slot (e.g., 10:00, 11:00, 12:00): ");
        String slot = sc.nextLine();

        try {
            hospital.scheduleAppointment(patientID, doctorID, slot);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        hospital.viewAppointments();
        sc.close();
    }
}
