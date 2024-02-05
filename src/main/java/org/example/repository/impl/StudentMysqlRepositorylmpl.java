package org.example.repository.impl;

import org.example.entity.Student;
import org.example.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentMysqlRepositorylmpl implements StudentRepository {

    private static final StudentMysqlRepositorylmpl INSTANCE = new StudentMysqlRepositorylmpl();
    private  StudentMysqlRepositorylmpl(){}

    public static StudentMysqlRepositorylmpl getInstance() {
        return INSTANCE;
    }




    @Override
    public void addStudent(Student student) {
        try {
            Connection conn = getConnection();

            String query = """
                    insert into employee ( name, surname, birthdate)
                     values(?, ?, ?); 
                    """;
         PreparedStatement stm = conn.prepareStatement(query);
        stm.setString(1, student.getName());
        stm.setString(2, student.getSurname());
        stm.setDate(3, Date.valueOf(student.getBirthDate()));

        stm.executeUpdate();

        conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }




    @Override
    public List<Student> getAllStudents() {
    try {
        Connection conn = getConnection();
        String  query = "select id, name, surname, birthdate from employee;";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Student> students= new ArrayList<>();

        while (resultSet.next()){
         long id = resultSet.getLong("id");
         String  name = resultSet.getString("name");
         String  surname = resultSet.getString("surname");
         Date birthdate = resultSet.getDate("birthdate");

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setSurname(surname);
            student.setBirthDate(birthdate.toLocalDate());

            students.add(student);

        }
        conn.close();
        return students;
    } catch (Exception ex){
      ex.printStackTrace();
        return Collections.emptyList();
    }


    }






    private Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//TODO error could happen
            String url = "jdbc:mysql://localhost:3306/vs_learning?useSSL=false";
            String username = "root";
            String pasword = "Sem@2024";

           return DriverManager.getConnection(url, username, pasword);
        } catch (Exception ex){
            ex.printStackTrace();
            throw  new RuntimeException("Exception occured");
        }

    }

}
