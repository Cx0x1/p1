package com.cxx.dao;

import com.cxx.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(dataSource);

    public int saveStudent(Student stu) {
        String sql = "insert into student values (null,?,?,?,?,?,?)";
        try {
            return qr.update(sql, stu.getName(), stu.getSex(),
                    stu.getHobby(), stu.getBirthday(), stu.getSdesc(), stu.getPhoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int findSelectCount(String sb, Object[] list) {
        List<Student> query = null;
        try {
            query = qr.query(sb, new BeanListHandler<Student>(Student.class), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query.size();
    }

    public List<Student> findSelectByLimit(String sb, Object[] list) {
        try {
            return qr.query(sb, new BeanListHandler<Student>(Student.class), list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int delAll(String sids) {
        String sql = "delete  from student where sid in (" + sids + ")";
        try {
            return qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student findStudent(String sid) {
        String sql = "select * from student where sid =?";
        try {
            return qr.query(sql, new BeanHandler<Student>(Student.class), sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateStudentBySid(Student stu) {
        String sql = "update student set name=?,sex=?,hobby=?,birthday=?,sdesc=?,photo=? where sid =?";

        try {
            return qr.update(sql, stu.getName(), stu.getSex(), stu.getHobby(), stu.getBirthday(), stu.getSdesc(), stu.getPhoto(), stu.getSid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
