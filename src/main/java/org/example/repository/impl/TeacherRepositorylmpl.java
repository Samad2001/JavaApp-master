package org.example.repository.impl;

import org.example.entity.Teacher;
import org.example.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//bitdi

public class TeacherRepositorylmpl implements TeacherRepository {

    public static final TeacherRepositorylmpl INSTANCE = new TeacherRepositorylmpl();

    private static final Map<Long, Teacher> teachers = new HashMap<>();
    private TeacherRepositorylmpl(){}

    public static TeacherRepositorylmpl getInstance(){
        return INSTANCE;
    }

    @Override
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getId(), teacher);
    }


    @Override
    public Teacher getById(Long id) {
        return teachers.get(id);
    }

    @Override
    public List<Teacher> getAll() {
        return new ArrayList<>(teachers.values());
    }
}
