package com.example.SpringBootWithMaven.model;

public class LogIn {

    private String name;
    private String ipAddress;
    private int yearOfBirth;
    private String password;

    public LogIn() {
    }

    public LogIn(String name, String ipAddress, int yearOfBirth, String password) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getPassword() {
        return password;
    }
}
