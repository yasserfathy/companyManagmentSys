/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.model;

/**
 *
 * @author yasser
 */
public class Employer {

    private int id;
    private int number;
    private String name;
    private int age;
    private String email;
    private String department;
    private int status;
    private int salary;
    private int workingYears;
    private String address;

    public Employer() {
    }

    public Employer(int id, int number, String name, int age, String email, String department, int status, int salary, int workingYears, String address) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.status = status;
        this.salary = salary;
        this.workingYears = workingYears;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(int workingYears) {
        this.workingYears = workingYears;
    }

}
