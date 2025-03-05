package com.student.crud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.crud.dao.StudentDAO;
// import com.student.crud.dao.StudentDAOImpl;
import com.student.crud.entity.Student;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);

			// System.out.println("-----------------------");
			// findStudent(studentDAO);

			// System.out.println("-----------------------");
			// findAllStudents(studentDAO);

			// System.out.println("-----------------------");
			// findStudentByLastName(studentDAO, "osama");
			
			// System.out.println("-----------------------");
			// updateStudentLastName(studentDAO);


			// System.out.println("-----------------------");
			// deleteStudent(studentDAO);

			// System.out.println("-----------------------");
			// deleteAllStudents(studentDAO);


			// System.out.println("-----------------------");
			// findAllStudents(studentDAO);

		};
	}

	public void createStudent(StudentDAO studentDAO){
		// create the student
		System.out.println("Creating 3 Students....");
		Student theStudent = new Student("omar", "moataz", "omar@gmail.com");
		Student student2 = new Student("ahmad", "osama", "ahmad@gmail.com");
		Student student3 = new Student("ali", "ahmed", "ali@gmail.com");

		// save it
		System.out.println("Saving them ....... ");
		studentDAO.save(theStudent);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// view its id
		System.out.println("Successfully created a student with id: " + theStudent.getId());
		System.out.println("Successfully created a student with id: " + student2.getId());
		System.out.println("Successfully created a student with id: " + student3.getId());

	}

	public void findStudent(StudentDAO studentDAO){
		System.out.println("retrieving a student with id 2");
		Student student = studentDAO.findById( 2);
		System.out.println(student);
	}

	public void findAllStudents(StudentDAO studentDAO){		
		// get all the students
		System.out.println("getting all the students......");
		List<Student> objects = studentDAO.findAll();

		// display all them 
		for (Student object: objects){
			System.out.println(object);
		}
	}

	public void findStudentByLastName(StudentDAO studentDAO ,String lastName){
		
		System.out.println("getting a student by last name......");
		List<Student> query = studentDAO.findByLastName(lastName);
	
		for (Student object:query){
			System.out.println(object);
		}
	
	}


	public void updateStudentLastName(StudentDAO studentDAO){

		Student theStudent = studentDAO.findById(3);

		System.out.println("updating a student last name......");
		studentDAO.updateLastName(theStudent, "ali");

		System.out.println(theStudent);
	}

	public void deleteStudent(StudentDAO studentDAO){

		int studentId = 1;
		System.out.println("deleting a student with id  " + studentId);

		studentDAO.delete(studentId);
	}

	public void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("deleting all the students... ");
		
		int numStudentsDeleted = studentDAO.deleteAll();
		System.out.println("number of Students deleted " + numStudentsDeleted);

	}

}
