
package Projects.Sutdent_Management_System;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String prg;
    private String sem;

    public Student(String id, String name, int age, String prg, String sem) {
        this.prg = prg;
        this.sem = sem;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPrg() {
        return prg;
    }
    public String getSem() {
        return sem;
    }



    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrg(String prg) {
        this.prg = prg;
    }
    public void setSem(String sem) {
        this.sem = sem;
    }

    @Override
    public String toString() {
        return "ID=" + id + ",      Name=" + name + ",      Age=" + age + ",        Semester=" + sem + ",       Program=" + prg;
    }
}


public class StudentManagementSystem {
    private ArrayList<Student> students_list;
    private Scanner scanner;

    public StudentManagementSystem() {
        students_list = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    // function to find std in id
    public Student findStudentById(String id) {
        for (Student student : students_list) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void print_list(ArrayList<Student>  list_to_print){
        for ( Student each_list: list_to_print){
                System.out.println(each_list);
        }
    }

    public void search_std(){
        System.out.println("\n----------------------- On what Basic You wanna search: -----------------------\n");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. Program");
        System.out.println("5. Semester");
        System.out.println("Enter your choice: ");
        int choice = 0;
        try{
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over (input buffer)
            }
        catch (InputMismatchException error_obj){
                scanner.nextLine();
                System.out.println("Sorry Only Number are aspectable, "+ error_obj);
                search_std();
            }

        switch (choice) {
            case 1:
                System.out.println("Enter Student ID to search: ");
                String id = scanner.nextLine();
                Student found_std = findStudentById(id);
                if (found_std == null){
                    System.out.println("No Data found...................................................\n");
                    break;
                }
                System.out.println(found_std);
                break;
            case 2:
                System.out.println("Enter Student Name to search: ");
                String name = scanner.nextLine();

                ArrayList<Student> found_std_list_name = new ArrayList<>();
                for (Student each_std : students_list)  {
                    if (each_std.getName().toUpperCase().equals(name.toUpperCase())){
                        found_std_list_name.add(each_std);
                    }
                }
                    if (found_std_list_name.isEmpty() ){
                    System.out.println("No Data found...................................................\n");
                    break;
                }
                print_list( found_std_list_name);
                break;
            case 3:
                System.out.println("Enter Student Age to search: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                ArrayList<Student> found_std_list_age = new ArrayList<>();
                
                for (Student each_std : students_list)  {
                    if (each_std.getAge() == age ){
                        found_std_list_age.add(each_std);
                    }
                }
                if (found_std_list_age.isEmpty() ){
                    System.out.println("No Data found...................................................\n");
                    break;
                }
                print_list( found_std_list_age);
                break;

            case 4:
                System.out.println("Enter Student Program to search: ");
                String prg = scanner.nextLine();


                ArrayList<Student> found_std_list_prg = new ArrayList<>();
                
                for (Student each_std : students_list)  {
                    if (each_std.getPrg().toUpperCase().equals(prg.toUpperCase()) ){
                        found_std_list_prg.add(each_std);
                    }
                }
                    if (found_std_list_prg.isEmpty() ){
                    System.out.println("No Data found...................................................\n");
                    break;
                }
                print_list( found_std_list_prg);
                break;

            case 5:
                System.out.println("Enter Student Semester to search: ");
                String sem = scanner.nextLine();

                ArrayList<Student> found_std_list_sem = new ArrayList<>();
                
                for (Student each_std : students_list)  {
                    if (each_std.getSem().toUpperCase().equals(sem.toUpperCase()) ){
                        found_std_list_sem.add(each_std);
                    }
                }
                print_list( found_std_list_sem);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }


    }

    // Add a new student
    public void addStudent() {
        System.out.println("\n General Information \n");
        System.out.println("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over


        System.out.println("\n Academic Information \n");
        System.out.println("Enter Student Program: ");
        String prg = scanner.nextLine();
        System.out.println("Enter Student Semester: ");
        String sem = scanner.nextLine();


        Student student = new Student(id, name, age,prg, sem);
        students_list.add(student);
        System.out.println("Student added successfully!");
    }

    // Remove a student by ID
    public void removeStudent() {
        System.out.println("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        Student removed_student = findStudentById(id);
        
        boolean removed = students_list.removeIf(student -> student.getId().equals(id));
        if (removed) {
            System.out.println("Student :" + removed_student);
            System.out.println("Removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Display all students
    public void displayStudents() {
        if (students_list.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students_list) {
                System.out.println(student);
            }
        }
    }

    // Main menu
    public void menu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Students, with Filter");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = 0;
            try{
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over (input buffer)
            }
            catch (InputMismatchException error_obj){
                scanner.nextLine();
                System.out.println("Sorry Only Number are aspectable, "+ error_obj);
                continue;
            }
            


            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                search_std();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
