package org.example.repository;

import org.example.entity.Teacher;

import java.util.List;


public interface TeacherRepository {

    void addTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();

}
