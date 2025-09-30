// CSCI 3302 - HW1I
// JOSHUA SIMPERS
// 8/29/2025
// File: Payroll.java
//
// This program will take data from the hours.txt file and calculate the pay for each employee on the payroll in the file including overtime

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Payroll {
     // TODO: Solve the problem
     public static void main(String[] args){
          try {
               // create a scanner to read data from the file
               File hoursFile = new File("hours.txt");
               Scanner fileScanner = new Scanner(hoursFile);
               // store the number of employees on the payroll to be used later
               int numberOfEmployees = Integer.parseInt(fileScanner.nextLine());
               // read the next line in the file up to the given number of employees
               double totalSalaryPaid = 0;
               for (int i = 0; i < numberOfEmployees; i++) {
                    // store the employee data as an array of strings
                    String[] employeeData = fileScanner.nextLine().split("\\s+");
                    // save the employee's id and hourly pay
                    String employeeID = employeeData[0];
                    double employeeHourlyPay = Double.parseDouble(employeeData[1]);
                    // calculate the amount of hours the employee worked in the week
                    double totalHoursWorked = 0;
                    for (int x = 2; x < employeeData.length; x++) {
                         totalHoursWorked += Double.parseDouble(employeeData[x]);
                    }
                    // calculate salary for the week, including overtime if hours are over 40
                    double weeklySalary;
                    if (totalHoursWorked > 40) {
                         double overtimeHours = totalHoursWorked - 40;
                         double overtimePay = (employeeHourlyPay * 1.5) * overtimeHours;
                         weeklySalary = (40 * employeeHourlyPay) + overtimePay;
                    } else {
                         weeklySalary = employeeHourlyPay * totalHoursWorked;
                    }
                    // add the employee's pay for the week to the total paid by the company 
                    totalSalaryPaid += weeklySalary;
                    // print out the employee's id and salary for the week
                    System.out.println("Employee: " + employeeID + ", Weekly Salary: $" + weeklySalary);
               }
               // print the total salary the company will pay at the end of the week
               System.out.println("Total Salary Paid by the Company: $" + totalSalaryPaid);
               fileScanner.close();
          }
          catch (FileNotFoundException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
          }
     }
}
