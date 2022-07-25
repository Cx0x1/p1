package com.cxx.service;

import com.cxx.dao.StudentDao;
import com.cxx.entity.Student;

import java.util.List;

public class StudentService {
    StudentDao dao=new StudentDao();
    public List<Student> findAll() {
        return dao.findAllStudentByLimit();
    }
}
