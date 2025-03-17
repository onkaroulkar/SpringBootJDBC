package com.onkar.SpringJDBC.repo;

import com.onkar.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

        String sql = "select * from student";

        /*RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setsName(rs.getString("sName"));
                s.setMarks(rs.getInt("rollNo"));
                s.setRollNo(rs.getInt("marks"));
                return s;
            }
        };*/

        // lambada expression
        RowMapper<Student> mapper = ( rs,  rowNum) -> {

                Student s = new Student();
                s.setsName(rs.getString("sName"));
                s.setMarks(rs.getInt("rollNo"));
                s.setRollNo(rs.getInt("marks"));
                return s;
        };
       return jdbc.query(sql,mapper);
    }
}
