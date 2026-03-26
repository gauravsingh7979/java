package com.student.service;

import com.student.model.Student;
import com.student.util.InvalidMarksException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentService {
    private static final String FILE_NAME = "students.txt";

    public void addStudent(Student student) throws InvalidMarksException {
        validateMarks(student.getMarks());

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(student.toFileString());
            writer.write(System.lineSeparator());
            System.out.println("Student record added successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while writing student details: " + e.getMessage());
        }
    }

    public void displayStudents() {
        boolean hasRecords = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Student Records:");

            while ((line = reader.readLine()) != null) {
                hasRecords = true;
                System.out.println(line);
            }

            if (!hasRecords) {
                System.out.println("No student records available.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Student record file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading student details: " + e.getMessage());
        }
    }

    private void validateMarks(double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
    }
}
