package com.student.crud.dao;

import com.student.crud.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);
}
