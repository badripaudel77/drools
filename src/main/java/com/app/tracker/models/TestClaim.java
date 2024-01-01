package com.app.tracker.models;

import java.time.LocalDate;

/*
 * For testing purposes
 */
public class TestClaim {
    private int id;
    private int testId;
    private String claimName;
    private LocalDate claimedDate;

    public TestClaim() {

    }

    public TestClaim(int id, int testId, String claimName, LocalDate claimedDate) {
        this.id = id;
        this.testId = testId;
        this.claimName = claimName;
        this.claimedDate = claimedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getClaimName() {
        return claimName;
    }

    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    public LocalDate getClaimedDate() {
        return claimedDate;
    }

    public void setClaimedDate(LocalDate claimedDate) {
        this.claimedDate = claimedDate;
    }

    @Override
    public String toString() {
        return "TestClaim{" +
                "id=" + id +
                ", testId=" + testId +
                ", claimName='" + claimName + '\'' +
                ", claimedDate=" + claimedDate +
                '}';
    }
}
