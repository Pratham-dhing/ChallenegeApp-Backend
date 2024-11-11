package com.challenges.ChallengesWebApp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Challenge {
    @Id
    private long id;
    @Column(name="challengeMonth")
    private String month;
    private String description;

    public Challenge() {
    }

    public Challenge(long id, String description, String month) {
        this.id = id;
        this.description = description;
        this.month = month;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
