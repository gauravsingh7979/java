package com.student;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.util.InvalidMarksException;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        try {
            studentService.addStudent(new Student(101, "Aarav", 87.5));
            studentService.addStudent(new Student(102, "Diya", 91.0));
            studentService.addStudent(new Student(103, "Kabir", 105.0));
        } catch (InvalidMarksException e) {
            System.out.println("InvalidMarksException: " + e.getMessage());
        }

        studentService.displayStudents();
    }
}
