package com.onkar.SpringJDBC.repo;

import com.onkar.SpringJDBC.model.Student;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    public void save(Student s){

        System.out.println("data saved");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
