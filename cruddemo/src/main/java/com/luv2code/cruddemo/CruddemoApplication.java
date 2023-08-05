package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.dao.StudentDAOImpl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();

		// retrieve student based on the id: primary key
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student by id: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
		Student tempStudent2 = new Student("Paul1", "Doe1", "paul1@luv2code.com");
		Student tempStudent3 = new Student("Paul2", "Doe2", "paul2@luv2code.com");

		// save the student objects
		System.out.println("Saving the student");
		studentDAO.save((tempStudent));
		studentDAO.save((tempStudent2));
		studentDAO.save((tempStudent3));
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student, Generated id: " + tempStudent.getId());
	}



}


