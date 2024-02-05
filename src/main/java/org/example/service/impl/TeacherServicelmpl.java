package org.example.service.impl;
import org.example.dto.request.AddTeacherRequest;
import org.example.dto.response.GetTeacherResponse;
import org.example.entity.Teacher;
import org.example.mapper.TeacherMapper;
import org.example.repository.TeacherRepository;
import org.example.repository.impl.TeacherMapRepositorylmpl;
import org.example.service.TeacherService;
import org.example.util.IdBuilderUtil;

import java.util.List;
public class TeacherServicelmpl implements TeacherService {

    private  static final TeacherServicelmpl INSTANCE= new TeacherServicelmpl();
    private final TeacherRepository teacherRepository = TeacherMapRepositorylmpl.getInstance();

    //    private final TeacherRepository teacherRepository = TeacherMapRepositorylmpl.getInstance();

    private final TeacherMapper teacherMapper = TeacherMapper.getINSTANCE();

    private TeacherServicelmpl(){

    }

    public static TeacherServicelmpl getInstance(){
        return INSTANCE;
    }


    @Override
    public void addTeacher(AddTeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toTeacher(teacherRequest);
        teacher.setId(IdBuilderUtil.getNewTeacherId());

        teacherRepository.addTeacher(teacher);
    }



    @Override
    public List<GetTeacherResponse> getAllTeacher() {
        List<Teacher> teacher = teacherRepository.getAllTeacher();
        return teacherMapper.toGetTeacherResponseList(teacher);
    }



}
