package org.example.dto.request;

//import java.util.Objects;

import java.util.Objects;

public class AddStudentRequest {

    private String name;
    private String surname;
    private String birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



     @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddStudentRequest that = (AddStudentRequest) o;
    return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthDate, that.birthDate);
    }

     @Override
     public int hashCode() {
     return Objects.hash(name, surname, birthDate);
     }


    @Override
    public String toString() {
        return "AddStudentRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

}
