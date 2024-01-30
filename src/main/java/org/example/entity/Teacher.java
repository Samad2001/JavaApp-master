package org.example.entity;

import java.util.Objects;

public class Teacher extends  Human{

    /*bitdi*/

    private Long id;
    private String subject;//todo


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, teacher.id) && Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, subject);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", "  + super.toString()+
                "} " ;
    }
}
