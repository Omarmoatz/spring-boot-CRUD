package com.student.crud.dao;

import java.util.List;

import com.student.crud.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void updateLastName(Student student, String lastName);

    void delete(int id);

    int deleteAll();
}
