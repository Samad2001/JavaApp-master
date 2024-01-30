package org.example.util;
import org.example.dto.request.AddStudentRequest;
import org.example.dto.request.AddTeacherRequest;
import java.util.Scanner;
//BITDI

public final class RequestBuilderUtil {

    private RequestBuilderUtil() {
    }

    public static AddStudentRequest buildAddStudentRequest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter student name:");
        String name = sc.nextLine();

        System.out.println("please enter student surname:");
        String surname = sc.nextLine();

        System.out.println("please enter student birthDate(in day/month/year format):");
        String birthdate = sc.nextLine();

        AddStudentRequest addStudentRequest = new AddStudentRequest();
        addStudentRequest.setName(name);
        addStudentRequest.setSurname(surname);
        addStudentRequest.setBirthDate(birthdate);

        return addStudentRequest;
    }


    public static AddTeacherRequest builAddTeacherRequest(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Please enter teacher name: ");
        String name = sc.nextLine();//TODO name ve surnameni deyisecem eger error atsa

        System.out.println("Please enter teacher surname: ");
        String surname= sc.nextLine();

        System.out.println("please enter student birthDate(in day/month/year format):");
        String birthdate = sc.nextLine();

        AddTeacherRequest addTeacherRequest = new AddTeacherRequest();
        addTeacherRequest.setName(name);
        addTeacherRequest.setSurname(surname);
        addTeacherRequest.setBirthDate(birthdate);

        return  addTeacherRequest;

    }



}
