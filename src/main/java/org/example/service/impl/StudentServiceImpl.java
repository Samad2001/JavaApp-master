package org.example.service.impl;
import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepository;
import org.example.repository.impl.StudentMapRepositoryImpl;
import org.example.repository.impl.StudentMysqlRepositorylmpl;
import org.example.service.StudentService;
import org.example.util.IdBuilderUtil;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final StudentServiceImpl INSTANCE = new StudentServiceImpl();
    private final StudentRepository studentRepository = StudentMysqlRepositorylmpl.getInstance();
//    private final StudentRepository studentRepository = StudentMapRepositoryImpl.getInstance();
    private final StudentMapper studentMapper = StudentMapper.getINSTANCE();

    private StudentServiceImpl() {
    }

    public static StudentServiceImpl getInstance() {
        return INSTANCE;
    }

    public void addStudent(AddStudentRequest request) {
        Student student = studentMapper.toStudent(request);
        student.setId(IdBuilderUtil.getNewStudentId());

        studentRepository.addStudent(student);
    }


    public List<GetStudentResponse> getAllStudents() {
        List<Student> students = studentRepository.getAllStudents();
        return studentMapper.toGetStudentResponseList(students);
    }

}
