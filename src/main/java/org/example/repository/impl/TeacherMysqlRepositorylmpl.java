package org.example.repository.impl;

import org.example.entity.Teacher;
import org.example.repository.TeacherRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherMysqlRepositorylmpl implements TeacherRepository {

    private static final TeacherMysqlRepositorylmpl INSTANCE = new TeacherMysqlRepositorylmpl();
    private  TeacherMysqlRepositorylmpl(){}

    public static TeacherMysqlRepositorylmpl getInstance() {
        return INSTANCE;
    }


    @Override
    public void addTeacher(Teacher teacher) {

        try {
            Connection conn = getConnection();

            String query = """
                    insert into employee ( name, surname, birthdate)
                     values(?, ?, ?); 
                    """;
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1,teacher.getName());
            stm.setString(2,teacher.getSubject());
            stm.setDate(3, Date.valueOf(teacher.getBirthDate()));

            stm.executeUpdate();

            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @Override
    public List<Teacher> getAllTeacher() {
        try {
            Connection conn = getConnection();
            String query = "select id, name, surname, birthdate from employee;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Teacher> teacherList = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date birthdate = resultSet.getDate("birthdate");
                //String subject= resultSet.getString("subject");//databaseda subject columnin add edende komenti ac

                Teacher teacher = new Teacher();
                teacher.setId(id);
                teacher.setName(name);
                teacher.setSurname(surname);
                teacher.setBirthDate(birthdate.toLocalDate());
                teacherList.add(teacher);//todo
            }

            conn.close();
            return teacherList;
        } catch(Exception ex){
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






