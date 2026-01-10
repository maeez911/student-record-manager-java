package com.app;

import java.util.HashMap;
import java.util.Scanner;

public class StudentManager{

    private HashMap<Integer, Student> students;

    public StudentManager(){
        students = new HashMap<>();
    }


    public void addStudent(Student student){
        if(students.containsKey(student.getId())){
            System.out.println("Student with this ID already exists.");
            return;
        }

        students.put(student.getId(), student);
        System.out.println("Student added successfully.");
    }

    public void updateStudent(int id){
       if (!students.containsKey(id)){
        System.out.println("Student not found.");
        return;
       }

       Student student = students.get(id);
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter new name: ");
       student.setName(scanner.nextLine());

       System.out.print("Enter new age: ");
       student.setAge(scanner.nextInt());
       scanner.nextLine();

       System.out.print("Enter new course: ");
       student.setCourse(scanner.nextLine());

       System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id){
        if(!students.containsKey(id)){
            System.out.println("Student not found.");
            return;
        }

        students.remove(id);
        System.out.println("Student deleted successfully.");
    }

    public void displayAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
            return;
        }

        for(Student student : students.values()){
            System.out.println(student);
        }
    }
    
}