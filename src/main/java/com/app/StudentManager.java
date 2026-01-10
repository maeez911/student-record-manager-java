package com.app;

import java.util.HashMap;

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

    }

    public void deleteStudent(int id){
        
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