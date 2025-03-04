package com.student.crud.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.crud.entity.Student;

import jakarta.persistence.EntityManager;



@Repository
public class StudentDaoImpl implements StudentDao{
    
    // define fields
    private EntityManager entityManager;
  
    // inject using constructor injection
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // override save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
}
