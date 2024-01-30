package org.example.service.impl;
import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepository;
import org.example.repository.impl.StudentRepositoryImpl;
import org.example.service.StudentService;
import org.example.util.IdBuilderUtil;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final StudentServiceImpl INSTANCE = new StudentServiceImpl();

    private final StudentRepository studentRepository = StudentRepositoryImpl.getInstance();
    private final StudentMapper studentMapper = StudentMapper.getINSTANCE();

    private StudentServiceImpl() {
    }

    public static StudentServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addStudent(AddStudentRequest request) {
        Student student = studentMapper.toStudent(request);
        student.setId(IdBuilderUtil.getNewId());

        studentRepository.addStudent(student);
    }

    @Override
    public List<GetStudentResponse> getAllStudents() {
        List<Student> students = studentRepository.getAll();
        return studentMapper.toGetStudentResponseList(students);
    }

}
