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
         * �п�
         **/
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = "3";
        }
//        �ַ���ת��
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);

//        ��������
        StringBuilder sb = new StringBuilder("select  * from student  where 1=1   ");

//      �洢ռλ��������
        ArrayList<Object> list = new ArrayList<>();
        if (name != null && !name.trim().equals("")) {
//            �û���д�� ��������
            sb.append("  and name like ?  ");
            list.add("%" + name + "%");
        }
        if (sex != null && !sex.trim().equals("")&& !"-1".equals(sex)) {
            sb.append("and sex=?");
            list.add(sex);
        }
//        �����ݿ�������
        int totaCount = dao.findSelectCount(sb.toString(), list.toArray());
        pb.setTotalCount(totaCount);
        // ����ҳ��=������%ÿҳ��ʾ����==0?������/ÿҳ��ʾ����:������/ÿҳ��ʾ����+1
        int totaPage = totaCount % size == 0 ? totaCount / size : totaCount / size + 1;
        pb.setTotalPage(totaPage);
//        �û��뿴��ҳ��
        sb.append(" limit ?,? ");
        //������ʼҳ  (��ǰҳ-1)*ÿҳ��ʾ����
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
