package org.example.service;

import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.dto.response.GetTeacherResponse;

import java.util.List;
//Bitdi
public interface TeacherService {

    void addTeacher(AddTeacherRequest teacherRequest);

    List<GetTeacherResponse> getAllTeacher();

}
