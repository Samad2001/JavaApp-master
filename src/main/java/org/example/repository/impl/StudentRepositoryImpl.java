package org.example.repository.impl;

import org.example.entity.Student;
import org.example.repository.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {

    private static final StudentRepositoryImpl INSTANCE = new StudentRepositoryImpl();
    private static final Map<Long, Student> students = new HashMap<>();

    // eager
    // lazy

    private StudentRepositoryImpl() {}

    public static StudentRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student getById(Long id) {
        return students.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

}
