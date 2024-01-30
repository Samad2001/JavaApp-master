package org.example.mapper;

import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.entity.Student;
import org.example.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    private static final StudentMapper INSTANCE = new StudentMapper();

    private StudentMapper() {
    }

    public static StudentMapper getINSTANCE() {
        return INSTANCE;
    }

    public Student toStudent(AddStudentRequest addStudentRequest) {
        Student student = new Student();
        student.setName(addStudentRequest.getName());
        student.setSurname(addStudentRequest.getSurname());
        student.setBirthDate(
                DateUtil.toLocalDate(
                        addStudentRequest.getBirthDate()
                )
        );

        return student;
    }

    public List<GetStudentResponse> toGetStudentResponseList(List<Student> studentList) {
        List<GetStudentResponse> getStudentResponseList = new ArrayList<>();

        for (Student student: studentList) {
            GetStudentResponse getStudentResponse = new GetStudentResponse();
            getStudentResponse.setId(student.getId());
            getStudentResponse.setName(student.getName());
            getStudentResponse.setSurname(student.getSurname());
            getStudentResponse.setBirthDate(
                    DateUtil.toString(
                            student.getBirthDate()
                    )
            );
            getStudentResponseList.add(getStudentResponse);
        }

        return getStudentResponseList;
    }

}
