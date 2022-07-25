package com.cxx.service;

import com.cxx.dao.StudentDao;
import com.cxx.entity.PageBean;
import com.cxx.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentDao dao = new StudentDao();

    public int addStudent(Student stu) {
        return dao.saveStudent(stu);
    }

    public PageBean findByPages(String name, String sex, String currentPage, String pageSize) {
        PageBean pb = new PageBean();
        /*
         * 判空
         **/
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = "3";
        }
//        字符串转换
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);

//        求总条数
        StringBuilder sb = new StringBuilder("select  * from student  where 1=1   ");

//      存储占位符的数组
        ArrayList<Object> list = new ArrayList<>();
        if (name != null && !name.trim().equals("")) {
//            用户填写的 名字条件
            sb.append("  and name like ?  ");
            list.add("%" + name + "%");
        }
        if (sex != null && !sex.trim().equals("")&& !"-1".equals(sex)) {
            sb.append("and sex=?");
            list.add(sex);
        }
//        查数据库总条数
        int totaCount = dao.findSelectCount(sb.toString(), list.toArray());
        pb.setTotalCount(totaCount);
        // 求总页数=总条数%每页显示条数==0?总条数/每页显示条数:总条数/每页显示条数+1
        int totaPage = totaCount % size == 0 ? totaCount / size : totaCount / size + 1;
        pb.setTotalPage(totaPage);
//        用户想看的页数
        sb.append(" limit ?,? ");
        //计算起始页  (当前页-1)*每页显示条数
        int start = (cpage - 1) * size;
        list.add(start);
        list.add(size);
        List<Student> list1 = dao.findSelectByLimit(sb.toString(), list.toArray());
        pb.setList(list1);

        return pb;
    }

    public int delAll(String sids) {
        return dao.delAll(sids);
    }

    public Student findStudent(String sid) {
        return dao.findStudent(sid);
    }

    public int updateStudent(Student stu) {
        return dao.updateStudentBySid(stu);
    }
}
