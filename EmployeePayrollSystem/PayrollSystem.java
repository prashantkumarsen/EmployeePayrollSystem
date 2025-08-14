package com.EmployeePayrollSystem;
import java.util.*;
import java.io.*;

public class PayrollSystem
{
    private static final String FILE_NAME ="employees.txt";
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args)
    {
        loadData();

        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Save & Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> {
                    saveData();
                    System.out.println("Data saved. Exiting...");
                    return;
            }
            default -> System.out.println("Invalid choice!");
        }
    }
}
   private static void addEmployee(Scanner sc){
       System.out.print("Enter ID: ");
       int id = sc.nextInt();
       sc.nextLine(); // consume newline
       System.out.print("Enter Name: ");
       String name = sc.nextLine();
       System.out.print("Enter Basic Salary: ");
       double basic = sc.nextDouble();
       System.out.print("Enter HRA: ");
       double hra = sc.nextDouble();
       System.out.print("Enter DA: ");
       double da = sc.nextDouble();
       System.out.print("Enter Deductions: ");
       double ded = sc.nextDouble();

       employees.add(new Employee(id, name, basic, hra, da, ded));
       System.out.println("Employee added successfully!");
   }

   private static void viewEmployees()
   {
        if (employees.isEmpty())
        {
            System.out.println("No employees found !!");
            return;
        }
       System.out.println("\n---Employee List ---");
        for (Employee emp : employees)
        {
            System.out.println(emp);
        }
   }

    @SuppressWarnings("unchecked")
    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
