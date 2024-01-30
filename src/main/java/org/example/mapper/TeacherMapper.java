package org.example.mapper;

import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetTeacherResponse;
import org.example.entity.Teacher;
import org.example.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

//Bitdi
public class TeacherMapper {

    private static final TeacherMapper INSTANCE = new TeacherMapper();
    private TeacherMapper(){

    }

    public static TeacherMapper getINSTANCE(){
        return  INSTANCE;
    }


    public Teacher toTeacher(AddTeacherRequest teacherRequest){
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequest.getName());
        teacher.setSurname(teacherRequest.getSurname());
        teacher.setBirthDate(DateUtil.toLocalDate(teacherRequest.getBirthDate()));
        return teacher;
    }

    public List<GetTeacherResponse> toGetTeacherResponseList(List<Teacher> teacherList){
        List<GetTeacherResponse> getTeacherResponseList = new ArrayList<>();

        for (Teacher teacher : teacherList){

            GetTeacherResponse getTeacherResponse = new GetTeacherResponse();
            getTeacherResponse.setId(teacher.getId());
            getTeacherResponse.setName(teacher.getName());
            getTeacherResponse.setSurname(teacher.getSurname());
            getTeacherResponse.setBirthDate(
                    DateUtil.toString(
                            teacher.getBirthDate()
                    )
            );
            getTeacherResponseList.add(getTeacherResponse);


        }
        return getTeacherResponseList;

    };


}
