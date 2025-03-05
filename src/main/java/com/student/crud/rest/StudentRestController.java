package com.student.crud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.crud.entity.Student;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private EntityManager entityManager;
    private List<Student> studentArr;
    
    @Autowired
    public StudentRestController(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @PostConstruct
    public void loadData(){
        System.out.println("-----------loadData---------------");
        

        System.out.println(studentArr);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        List<Student> students = query.getResultList();
        
        studentArr = new ArrayList<>();
        for (Student obj: students){
            studentArr.add(obj);
        }
        // spring and jackson will convert it into JSON in the background
        return studentArr;
    }


    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Student student = entityManager.find(Student.class, studentId); 
        // System.out.println(student);
        return studentArr.get(studentId);
    }

}
