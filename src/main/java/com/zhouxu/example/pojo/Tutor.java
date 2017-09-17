package com.zhouxu.example.pojo;

/**
 * Created by zhouxu on 2017/9/12 22:38.
 */


public class Tutor {

    private Integer tutorId;
    private String name;
    private String email;

    public Tutor() {
    }

    public Tutor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Tutor(Integer tutorId, String name, String email) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
    }


    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId=" + tutorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
