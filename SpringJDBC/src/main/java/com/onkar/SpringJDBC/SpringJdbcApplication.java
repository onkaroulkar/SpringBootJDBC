package com.onkar.SpringJDBC;
import com.onkar.SpringJDBC.Service.StudentService;
import com.onkar.SpringJDBC.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setMarks(104);
		s.setsName("onkar");
		s.setRollNo(1);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		List<Student> student = service.getStudent();
		System.out.println(student);
	}
}
