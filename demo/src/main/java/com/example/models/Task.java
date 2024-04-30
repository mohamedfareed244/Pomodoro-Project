package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Task {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int focusDuration;
    private int breakDuration;
    private int totalDuration;

    public Task() {
        // Default constructor required for JPA
    }

    public Task(String name, int focusDuration, int breakDuration) {
        this.name = name;
        this.focusDuration = focusDuration;
        this.breakDuration = breakDuration;
        this.totalDuration = 0;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFocusDuration() {
        return focusDuration;
    }

    public void setFocusDuration(int focusDuration) {
        this.focusDuration = focusDuration;
    }

    public int getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(int breakDuration) {
        this.breakDuration = breakDuration;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public void startTimer() {
        System.out.println("Starting Pomodoro timer for task: " + name);
        System.out.println("Focus for " + focusDuration + " minutes...");

        // Simulate the focus period
        try {
            Thread.sleep(focusDuration * 1000 * 60); // Convert minutes to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalDuration += focusDuration; // Update the total duration

        System.out.println("Break for " + breakDuration + " minutes...");

        // Simulate the break period
        try {
            Thread.sleep(breakDuration * 1000 * 60); // Convert minutes to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalDuration += breakDuration; // Update the total duration

        System.out.println("Pomodoro completed for task: " + name);
        System.out.println("Total duration spent: " + totalDuration + " minutes");
    }
}

