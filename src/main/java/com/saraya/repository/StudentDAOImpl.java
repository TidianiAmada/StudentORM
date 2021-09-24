package com.saraya.repository;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnits;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.saraya.entity.Student;

@Repository("studentRepository")
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManagerFactory emt;
	
	@PersistenceUnit
	public void setEmt(EntityManagerFactory emt) {
		this.emt = emt;
	}

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		EntityManager entityManager = this.emt.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public int remove(String prenom_nom) {
		// TODO Auto-generated method stub
		EntityManager entityManager = this.emt.createEntityManager();
		entityManager.getTransaction().begin();
		int result=0;
		try {
			Student std=entityManager.find(Student.class, prenom_nom);
			entityManager.remove(std);
			entityManager.getTransaction().commit();
			result=1;
		} catch(Exception ex) {
			entityManager.getTransaction().rollback();
		}
		entityManager.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		EntityManager entityManager = this.emt.createEntityManager();
		entityManager.getTransaction().begin();
		Query query= entityManager.createQuery("select `prenom_nom` from `inscription_list`");
		
		
		return (ArrayList<Student>) query.getResultList();
	}

	@Override
	public void update(java.util.Date date_de_naissance, String adresse, String prenom_nom) {
		// TODO Auto-generated method stub
		EntityManager entityManager = this.emt.createEntityManager();
		entityManager.getTransaction().begin();
		
		Student std=entityManager.find(Student.class, prenom_nom);
		std.setAdresse(adresse);
		std.setDate_de_naissance(date_de_naissance);
		entityManager.getTransaction().commit();
	
		entityManager.close();
	}

	
}
