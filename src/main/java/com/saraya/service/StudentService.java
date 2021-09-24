package com.saraya.service;


import java.util.ArrayList;
import java.util.Date;

import com.saraya.dto.StudentDTO;
import com.saraya.entity.Student;

public interface StudentService {
	public void insert(Student student);
	public int remove(String prenom_nom); 
	public ArrayList<StudentDTO> getAllStudent(); 
	public void update(Date date_de_naissance, String adresse, String prenom_nom);
}
