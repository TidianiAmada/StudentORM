package com.saraya.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.dto.StudentDTO;
import com.saraya.entity.Student;
import com.saraya.repository.StudentDAO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO std;
	
	public void insert(StudentDTO student) {
		// TODO Auto-generated method stub
		std.insert(StudentDTO.prepareStudentEntity(student));
	}

	public int remove(String prenom_nom) {
		// TODO Auto-generated method stub
		return std.remove(prenom_nom);
	}

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<StudentDTO> getAllStudent() {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> student= new ArrayList<>();
		ArrayList<Student> eleve= std.getAllStudent();
		for(Student ev:eleve) {
			StudentDTO dsp=Student.prepareDTO(ev);
			student.add(dsp);
		}
		return student;
	}

	@Override
	public void update(Date date_de_naissance, String adresse, String prenom_nom) {
		// TODO Auto-generated method stub
		std.update(date_de_naissance, adresse, prenom_nom);
	}

}
