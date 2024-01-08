package com.app.tracker.models;

public class Category {

    private Integer categoryId;
    private String categoryName;

    private Patient patient;

    public Category(Integer categoryId, String categoryName, Patient patient) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.patient = patient;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
