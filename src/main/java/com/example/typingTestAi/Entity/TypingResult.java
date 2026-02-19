package com.example.typingTestAi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
public class TypingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private int wpm;

    private double accuracy;

    private int timetaken;

    private LocalDateTime testDate;

    public TypingResult(){
        this.testDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(int timetaken) {
        this.timetaken = timetaken;
    }

    public LocalDateTime getTestDate() {
        return testDate;
    }
}