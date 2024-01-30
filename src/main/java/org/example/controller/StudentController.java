package org.example.controller;

import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.service.StudentService;
import org.example.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {

    private static final StudentController INSTANCE = new StudentController();

    private final StudentService studentService = StudentServiceImpl.getInstance();

    private StudentController() {
    }

    public static StudentController getInstance() {
        return INSTANCE;
    }

    public void addStudent(AddStudentRequest request) {
        studentService.addStudent(request);
    }

    public List<GetStudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

}
