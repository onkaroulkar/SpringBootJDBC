package com.onkar.SpringJDBC.repo;
import com.onkar.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){

        String sql = "insert into student (sName,rollNo,marks) values(?,?,?)";
        int rows = jdbc.update(sql,s.getsName(),s.getRollNo(),s.getMarks());
        System.out.println(rows + "affected");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
