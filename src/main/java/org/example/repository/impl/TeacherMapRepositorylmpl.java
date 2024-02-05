package org.example.repository.impl;

import org.example.entity.Teacher;
import org.example.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TeacherMapRepositorylmpl implements TeacherRepository {

    public static final TeacherMapRepositorylmpl INSTANCE = new TeacherMapRepositorylmpl();
    private static final Map<Long, Teacher> teachers = new HashMap<>();
    private TeacherMapRepositorylmpl(){}

    public static TeacherMapRepositorylmpl getInstance(){
        return INSTANCE;
    }

    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getId(), teacher);
    }

    public List<Teacher> getAllTeacher() {
        return new ArrayList<>(teachers.values());
    }

}
