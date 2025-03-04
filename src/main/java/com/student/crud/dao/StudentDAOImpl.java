package com.student.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.crud.entity.Student;

import jakarta.persistence.EntityManager;



@Repository
public class StudentDAOImpl implements StudentDAO{
    
    // define fields
    private EntityManager entityManager;
  
    // inject using constructor injection
    @Autowired  // not necessary if there is only one constructor 
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // override save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }
}
