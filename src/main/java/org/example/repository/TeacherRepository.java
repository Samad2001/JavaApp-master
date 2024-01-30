package org.example.repository;

import org.example.entity.Teacher;

import java.util.List;
//bitdi

public interface TeacherRepository {

    void addTeacher(Teacher teacher);

    Teacher getById(Long id);
    List<Teacher> getAll();

}
