package com.app;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n--- Student Record Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.print("ENTER ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("ENTER NAME: ");
                String name = scanner.nextLine();

                System.out.print("ENTER AGE: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("ENTER COURSE: ");
                String course = scanner.nextLine();

                Student student = new Student(id, name, age, course);
                manager.addStudent(student);

            }else if(choice == 2){
                manager.displayAllStudents();

            }else if(choice == 3){
                System.out.println("Exiting...");
                break;

            }else{
                System.out.println("Invalid choice!");
            }

        }

        scanner.close();

    }
}

