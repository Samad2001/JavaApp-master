package org.example.service;

import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;

import java.util.List;

public interface StudentService {

    void addStudent(AddStudentRequest request);
    List<GetStudentResponse> getAllStudents();

}
