// Class: CSCI 3302
// Names: Joshua Simpers and Luis Rangel
// File Name: Student.java
// Purpose: make a linked list of Student objects with names
//      addresses, class levels, and majors
// Requirements:
//      Read students from a file
//      Write students to a file
//      Remove a student from the list
//      Add a student to the list
//      Print the list of students in a clean format
//      Sort students based on last name, first name


package LinkedNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String academicLevel;
    private String localAddress;
    private String email;
    private String major;
    private String preferredFirstName;

    public Student(String firstName, String lastName, String academicLevel, String localAddress, String email, String major, String preferredFirstName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicLevel = academicLevel;
        this.localAddress = localAddress;
        this.email = email;
        this.major = major;
        this.preferredFirstName = preferredFirstName;
    }

    public Student(String firstName, String lastName, String academicLevel, String localAddress, String email, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicLevel = academicLevel;
        this.localAddress = localAddress;
        this.email = email;
        this.major = major;
        this.preferredFirstName = "Not Specified";
    }

    @Override
    public int compareTo(Student student) {
        String studentData1 = this.lastName + this.firstName;
        String studentData2 = student.lastName + student.firstName;
        return studentData1.compareTo(studentData2);
    }

    @Override
    public String toString() {
        return "Last Name: " + this.lastName + ", First Name: " + this.firstName + ", Academic Level: " + this.academicLevel
            + ", Address: " + this.localAddress + ", Email: " + this.email + ", Major: "
            + this.major + ", Preferred Name: " + this.preferredFirstName;
    }

    // capitalizes the first letter of each given name and address of the student if they were not already
    private void capitalizationCheck() {
        String[] names = {this.lastName, this.firstName, this.preferredFirstName};
        for (String name : names) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }

    // checks the given academic level of the student to see if it is an appropriate value
    private boolean academicCheck() {
        Boolean result = false;
        String[] acceptedLevels = {"freshman", "sophomore", "junior", "senior", "graduate"};
        String lowercaseLevel = this.academicLevel.toLowerCase();
        for (String level : acceptedLevels) {
            if (lowercaseLevel.equals(level)) {
                result = true;
            }
        }
        if (!result) {
            System.out.println("Error: Incorrect academic level for Student: " + this.firstName + " " + this.lastName);
        }
        return result;
    }

    // tests if the student being added to the list is already in the list or not
    private boolean duplicationCheck(LinkedList<Student> studentList) {
        boolean result = false;
        for (Student student : studentList) {
            if (this.compareTo(student) == 0) {
                System.out.println("Error: Student: " + this.firstName + " " + this.lastName + " is already in the list");
                result = true;
            }
        }
        return result;
    }

    // runs a series of checks to "filter" new objects
    public boolean runChecks(LinkedList<Student> studentList) {
        // true for success, false for errors
        boolean result = true;
        this.capitalizationCheck();
        // if the student is already in the list, or the academic value is not correct, then runChecks() will return false
        if (this.academicCheck() == false || this.duplicationCheck(studentList)) {
            result = false;
        }
        return result;
    }

    // writes the student to the classList.txt file from the given list of students as well as adding it to the list
    public void addStudentToFile(LinkedList<Student> studentList) {
        if (this.runChecks(studentList)) {
            try {
                File listFile = new File("LinkedNode/classList.txt");
                BufferedWriter listWriter = new BufferedWriter(new FileWriter(listFile, true));
                listWriter.newLine();
                listWriter.write(this.firstName + ", " + this.lastName + ", " + this.academicLevel + ", "
                                + this.localAddress + ", " + this.email + ", " + this.major + ", " + this.preferredFirstName);
                listWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            studentList.insert(this);
        }
    }
}
