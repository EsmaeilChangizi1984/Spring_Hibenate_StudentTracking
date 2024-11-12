package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}

		@Bean
		CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			 //updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
		}


	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object.");
		Student temStudent = new Student("Esmaeil","Changizi","esmael@gmail.com");
		studentDAO.save(temStudent);
		System.out.println("Saved Student generated id : "+temStudent.getId());

		System.out.println("Creating new student object.");
		Student theStudent = new Student("ELHAM","ASADI","ellie1@gmail.com");
		studentDAO.save(theStudent);
		System.out.println("Saved Student generated id : "+theStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {

		Student mystudent = new Student("Alex","Alvarez","alex2gmmail.com");
		studentDAO.save(mystudent);
		int id = mystudent.getId();

		Student tempstudent = studentDAO.findById(id);
		System.out.println("The Student with this id : "+tempstudent);

	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("Asadi");
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with ID : "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student ...");
		myStudent.setFirstName("Ben");
		studentDAO.update(myStudent);
		System.out.println("Updated student : "+myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting the student id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting All Students from Database");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of Rows deleted : "+numRowsDeleted);
	}





}
