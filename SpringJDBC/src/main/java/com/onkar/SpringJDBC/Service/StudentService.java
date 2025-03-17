package com.onkar.SpringJDBC.Service;

import com.onkar.SpringJDBC.model.Student;
import com.onkar.SpringJDBC.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private Repository repo;

    public Repository getRepo() {
        return repo;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s);
    }

    public List<Student> getStudent() {
        return repo.findAll();
    }
}
