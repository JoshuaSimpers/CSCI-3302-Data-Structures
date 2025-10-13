// Class: CSCI 3302
// Names: Joshua Simpers and Luis Rangel
// File Name: TestList.java
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

import java.util.Scanner;
import java.io.File;

public class TestList {

    public static void PrintList(LinkedList<Student> list) {
        for(Student item : list) {
            System.out.println(item);
        }
        System.out.println();
    }

    // gets the student objects from the classList.txt file and compiles them into a list of students
    public static LinkedList<Student> getListFromFile() {
        LinkedList<Student> newStudentList = new LinkedList<Student>();
        try {
            File listFile = new File("LinkedNode/classList.txt");
            Scanner listScanner = new Scanner(listFile);
            String nextStudent = listScanner.nextLine();
            while (listScanner.hasNext()) {
                // moves to the second line in the file as the first line is used for describing
                // the formatting of the file's information
                nextStudent = listScanner.nextLine();
                String[] newStudentInfo = nextStudent.split(", ");
                Student newStudent = new Student(newStudentInfo[0], newStudentInfo[1], newStudentInfo[2], newStudentInfo[3],
                                     newStudentInfo[4], newStudentInfo[5], newStudentInfo[6]);
                // if the student was already in the list, or there was an error with its academic level, 
                // then do not add the student to the list
                if (newStudent.runChecks(newStudentList) == false) {
                    System.out.println("Could not add Student: " + newStudentInfo[0] + " " + newStudentInfo[1] + " to the list.");
                } else {
                    newStudentList.insert(newStudent);
                }
            }
            listScanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newStudentList;
    }

    public static void main(String[] args) {

        LinkedList<Student> studentList = getListFromFile();

        // create 4 new students not in the file
        Student defaultStudent = new Student("John", "Smith", "Freshman", "1234 Fake St.", "johnsmith@someschool.net", "General Studies", "John");
        Student darthVader = new Student("Darth", "Vader", "Graduate", "Death Star", "darthvader@evil.net", "Sith Studies", "Vader");
        Student lukeSkywalker = new Student("Luke", "Skywalker", "Senior", "Tattooine", "lskywalker@jedi.com", "Rebel Leadership", "Luke");
        Student errorStudent = new Student("Jacob", "Smith", "Doctor", "1121 Know Way", "jacobsmith@someschool.net", "Doctor Stuff", "Jake");
        Student defaultStudentCopy = new Student("John", "Smith", "Freshman", "1234 Fake St.", "johnsmith@someschool.net", "General Studies", "John");

        // Print the list of students
        PrintList(studentList);

        // Add the four new students to the file then update the student list again
        defaultStudent.addStudentToFile(studentList);
        darthVader.addStudentToFile(studentList);
        lukeSkywalker.addStudentToFile(studentList);
        // Should not work: incorrect academic level
        errorStudent.addStudentToFile(studentList);
        // Should not work: copy of an existing student
        defaultStudentCopy.addStudentToFile(studentList);
        studentList = getListFromFile();

        // Print the list again
        PrintList(studentList);    
    }
}
