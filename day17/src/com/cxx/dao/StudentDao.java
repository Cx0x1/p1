package com.cxx.dao;

import com.cxx.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(dataSource);
    public List<Student> findAllStudentByLimit() {

        String sql="select * from student limit ?,?";
        try {
            return qr.query(sql,new BeanListHandler<Student>(Student.class),0,5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
