package com.saraya.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.saraya.entity.Student;

public interface StudentDAO {
	public void insert(Student student);
	public int remove(String prenom_nom); 
	public ArrayList<Student> getAllStudent(); 
	public void update(Date date_de_naissance, String adresse, String prenom_nom);
}
