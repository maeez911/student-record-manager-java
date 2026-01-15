package com.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class StudentManager{

    private HashMap<Integer, Student> students;
    private static final String FILE_NAME = "students.txt";

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
        saveToFile();
    }

    public void updateStudent(int id, String name, int age, String course){
       if (!students.containsKey(id)){
        System.out.println("Student not found.");
        return;
       }

       Student student = students.get(id);
       student.setName(name);
       student.setAge(age);
       student.setCourse(course);

       saveToFile();
       System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id){
        if(!students.containsKey(id)){
            System.out.println("Student not found.");
            return;
        }

        students.remove(id);
        System.out.println("Student deleted successfully.");
        saveToFile();
    }

    public void printAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
            return;
        }

        for(Student student : students.values()){
            System.out.println(student);
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String course = parts[3];

                students.put(id, new Student(id, name, age, course));
            }
        } catch (IOException e) {
            System.out.println("Error loading students.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students.values()) {
                writer.write(student.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
    
}