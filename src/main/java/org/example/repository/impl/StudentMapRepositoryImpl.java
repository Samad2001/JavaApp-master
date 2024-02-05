package org.example.repository.impl;

import org.example.entity.Student;
import org.example.repository.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapRepositoryImpl implements StudentRepository {

    private static final StudentMapRepositoryImpl INSTANCE = new StudentMapRepositoryImpl();
    private static final Map<Long, Student> students = new HashMap<>();

    private StudentMapRepositoryImpl() {}

    public static StudentMapRepositoryImpl getInstance() {
        return INSTANCE;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }


    public List<Student> getAllStudents() {
        return  new ArrayList<>(students.values());
    }



}
