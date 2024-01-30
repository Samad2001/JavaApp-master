package org.example.service.impl;
import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetTeacherResponse;
import org.example.entity.Teacher;
import org.example.mapper.TeacherMapper;
import org.example.repository.TeacherRepository;
import org.example.repository.impl.TeacherRepositorylmpl;
import org.example.service.TeacherService;
import org.example.util.IdBuilderUtil;

import java.util.List;
//BITDI
public class TeacherServicelmpl implements TeacherService {

    private  static final TeacherServicelmpl INSTANCE= new TeacherServicelmpl();
    private final TeacherRepository teacherRepository = TeacherRepositorylmpl.getInstance();
    private final TeacherMapper teacherMapper = TeacherMapper.getINSTANCE();

    private TeacherServicelmpl(){

    }

    public static TeacherServicelmpl getInstance(){
        return INSTANCE;
    }


    @Override
    public void addTeacher(AddTeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toTeacher(teacherRequest);
        teacher.setId(IdBuilderUtil.getNewId());

        teacherRepository.addTeacher(teacher);
    }

    @Override
    public List<GetTeacherResponse> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.getAll();
        return teacherMapper.toGetTeacherResponseList(teachers);
    }



}
