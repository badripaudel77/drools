package com.app.tracker.models;

public class Patient {

    private Integer patientId;
    private String patientName;
    private Address patientAddress;

    public Patient() {

    }

    public Patient(Integer patientId, String patientName, Address patientAddress) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Address getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(Address patientAddress) {
        this.patientAddress = patientAddress;
    }
}
