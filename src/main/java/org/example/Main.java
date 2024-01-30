package org.example;

import org.example.controller.StudentController;
import org.example.controller.TeacherController;
import org.example.dto.request.AddStudentRequest;
import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.dto.response.GetTeacherResponse;
import org.example.util.RequestBuilderUtil;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final StudentController studentController = StudentController.getInstance();

    private static final TeacherController teacherConTroller = TeacherController.getInstance();

    public static void main(String[] args) {
        // dto -> Data Transfer Object

        // name surname birthdate  10/09/2000
        // fullName birthdate
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("""
                ----------------------------------------------------
                Choose your process:
                1. add Student
                2. get All Student
                3.get Teacher
                4.get All Teacher""");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                getAllStudents();
                break;
            case 3 ://TODO THIS PROBLEMS
               addTeacher();
                break;
            case 4:
                getAllTeachers();
                break;
            default:
                System.out.println("your choice is not ok for us. please try again.");
        }
    }

    private static void addStudent() {
        AddStudentRequest addStudentRequest = RequestBuilderUtil.buildAddStudentRequest();
        studentController.addStudent(addStudentRequest);
        System.out.println("student added successfully");
    }

    private static void getAllStudents() {
        List<GetStudentResponse> students = studentController.getAllStudents();
        for (GetStudentResponse student : students) {
            System.out.println(student.toString());
        }
    }
        //TODO ERROR bas verir onu hell et
        private static  void addTeacher(){
            AddTeacherRequest addTeacherRequest = RequestBuilderUtil.builAddTeacherRequest();
            teacherConTroller.addTeacher(addTeacherRequest);
            System.out.println("teacher added succcesfully");
        }

        private static  void getAllTeachers(){
            List<GetTeacherResponse> teachers = teacherConTroller.getAllTeachers();
            for (GetTeacherResponse teacher : teachers){
                System.out.println(teacher.toString());
            }

        }

    }


