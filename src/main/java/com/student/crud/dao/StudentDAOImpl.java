package com.student.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;



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

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery =  entityManager.createQuery("FROM Student", Student.class);  
        return theQuery.getResultList();
    } 

    @Override
    public List<Student> findByLastName(String theLastName){
        // create the query
        TypedQuery<Student> query = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);

        // set the parameter
        query.setParameter("theData", theLastName);

        // return the query
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateLastName(Student student, String lastName){
        student.setLastName(lastName);
        entityManager.merge(student); 
    }

    @Override
    @Transactional
    public void delete(int id){
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }
}
