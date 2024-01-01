package com.app.tracker.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represent customer user class who is a general user
 * Can have different roles if implemented
 */
public class CustomerUser {
    private int userId;
    private String username; // could be email or just part before @ in the email
    private LocalDate createdAt = null; // LocalDate.now();
    private boolean locked = true; // by default true
    private LocalDateTime lastSeenDateAndTime = null; // tracks the last seen date time, by default null
    private String status = "PENDING";

    public CustomerUser() {

    }

    public CustomerUser(int userId, String username, LocalDate createdAt, boolean locked, LocalDateTime lastSeenDateAndTime, String status) {
        this.userId = userId;
        this.username = username;
        this.createdAt = createdAt;
        this.locked = locked;
        this.lastSeenDateAndTime = lastSeenDateAndTime;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setIsLocked(boolean locked) {
        locked = locked;
    }

    public LocalDateTime getLastSeenDateAndTime() {
        return lastSeenDateAndTime;
    }

    public void setLastSeenDateAndTime(LocalDateTime lastSeenDateAndTime) {
        this.lastSeenDateAndTime = lastSeenDateAndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", createdAt=" + createdAt +
                ", locked=" + locked +
                ", status=" + status +
                ", lastSeenDateAndTime=" + lastSeenDateAndTime +
                '}';
    }
}
