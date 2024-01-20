package com.app.tracker.models;

public class Company {
    private Integer cmpId;
    private String name;
    private CompanySize size;
    private Integer empCount;

    public Company() {
    }

    public Company(Integer cmpId, String name, CompanySize size, Integer empCount) {
        this.cmpId = cmpId;
        this.name = name;
        this.size = size;
        this.empCount = empCount;
    }

    public Integer getCmpId() {
        return cmpId;
    }

    public void setCmpId(Integer cmpId) {
        this.cmpId = cmpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanySize getsize() {
        return size;
    }

    public void setsize(CompanySize size) {
        this.size = size;
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cmpId=" + cmpId +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", empCount=" + empCount +
                '}';
    }
}
