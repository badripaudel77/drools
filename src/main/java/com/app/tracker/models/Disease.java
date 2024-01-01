package com.app.tracker.models;

import com.app.tracker.utils.StatusEnum;

public class Disease {
    private Integer diseaseCode;
    private String name;
    private boolean isIncurable;
    private StatusEnum statusEnum;

    public Disease(Integer diseaseCode, String name, boolean isIncurable, StatusEnum statusEnum) {
        this.diseaseCode = diseaseCode;
        this.name = name;
        this.isIncurable = isIncurable;
        this.statusEnum = statusEnum;
    }

    public Integer getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(Integer diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIncurable() {
        return isIncurable;
    }

    public void setIncurable(boolean isIncurable) {
        isIncurable = isIncurable;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "diseaseCode=" + diseaseCode +
                ", name='" + name + '\'' +
                ", status='" + statusEnum + '\'' +
                ", isIncurable=" + isIncurable +
                '}';
    }
}
