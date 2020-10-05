package com.twc.javaBasic.util;

import java.time.LocalDate;

public class FieldNotExplicitlyInitialized {
    private String name;
    private int yearOfBirth;
    private LocalDate registeredDate;

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }
}
