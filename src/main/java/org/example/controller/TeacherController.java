package org.example.controller;

import org.example.dto.request.AddStudentRequest;
import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetTeacherResponse;
import org.example.service.TeacherService;
import org.example.service.impl.TeacherServicelmpl;

import java.util.List;


public class TeacherController {


    private static final TeacherController INSTANCE = new TeacherController();
    private  final TeacherService teacherService=  TeacherServicelmpl.getInstance();


    private TeacherController() {
    }

    public static TeacherController getInstance(){
        return INSTANCE;
    }

    public void addTeacher(AddTeacherRequest teacherRequest){
      teacherService.addTeacher(teacherRequest);
    }


public List<GetTeacherResponse> getAllTeachers(){
        return  teacherService.getAllTeacher();
}

}
