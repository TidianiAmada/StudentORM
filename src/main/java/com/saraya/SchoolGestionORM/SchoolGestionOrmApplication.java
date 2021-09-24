package com.saraya.SchoolGestionORM;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.saraya.dto.StudentDTO;
import com.saraya.entity.Student;
import com.saraya.service.StudentService;

@SpringBootApplication
public class SchoolGestionOrmApplication implements CommandLineRunner {

//	public static void main(String[] args) {
//		SpringApplication.run(SchoolGestionOrmApplication.class, args);
//	}
static Logger logger= Logger.getLogger(Student.class);

AbstractApplicationContext context;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		StudentService studentService= (StudentService) context.getBean("studentService");
		
		StudentDTO student1 =new StudentDTO("babacar", "Ndar");
		StudentDTO student2 =new StudentDTO("khady", "Mboro");
		StudentDTO student3 =new StudentDTO("abdou", "Tciakalaar");
		
		studentService.insert(student1);
		studentService.insert(student2);
		studentService.insert(student3);
		logger.info("Succesfully added");
		context.close();
		
	}

}
