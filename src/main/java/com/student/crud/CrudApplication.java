package com.student.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.crud.dao.StudentDaoImpl;
import com.student.crud.entity.Student;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDaoImpl studentDaoImpl){
		return runner -> {
			createStudent(studentDaoImpl);
		};
	}

	public void createStudent(StudentDaoImpl studentDaoImpl){
		// create the student
		System.out.println("Creating 3 Students....");
		Student theStudent = new Student("omar", "moataz", "omar@gmail.com");
		Student student2 = new Student("ahmad", "osama", "ahmad@gmail.com");
		Student student3 = new Student("ali", "ahmed", "ali@gmail.com");

		// save it
		System.out.println("Saving them ....... ");
		studentDaoImpl.save(theStudent);
		studentDaoImpl.save(student2);
		studentDaoImpl.save(student3);

		// view its id
		System.out.println("Successfully created a student with id: " + theStudent.getId());
		System.out.println("Successfully created a student with id: " + student2.getId());
		System.out.println("Successfully created a student with id: " + student3.getId());

	}

}
