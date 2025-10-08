package com.SmartHospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Patient
{
    private String patientID;
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patient(String patientID, String name, int age)
    {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public String getPatientID() 
    {
        return patientID;
    }

    public String getName()
    
    {
        return name;
    }

    public void addMedicalHistory(String record) 
    {
        medicalHistory.add(record);
    }

    public void viewMedicalHistory()
    {
        System.out.println("Medical History of " + name + ":");
        for(String record : medicalHistory)
        {
            System.out.println("- " + record);
        }
    }
}

