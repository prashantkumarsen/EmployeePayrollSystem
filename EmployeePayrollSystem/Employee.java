package com.EmployeePayrollSystem;

import java.io.Serializable;

public class Employee implements Serializable
{
   private int id;
   private String name;
   private double basicSalary;
   private double hra; // House Rent Allowance
   private double dearness; //Dearness Allowance
   private double deductions;

    public Employee(int id, String name, double basicSalary, double hra, double dearness, double deductions) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.dearness = dearness;
        this.deductions = deductions;
    }

    public double calculateNetSalary()
    {
        return basicSalary + hra + dearness - deductions;
    }

    @Override
    public String toString()
    {
        return id + " | " + name + " | Basic: " + basicSalary +
                " | Net Salary: " + calculateNetSalary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDearness() {
        return dearness;
    }

    public void setDearness(double dearness) {
        this.dearness = dearness;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }
}
