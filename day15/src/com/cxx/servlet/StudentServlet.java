package com.cxx.servlet;

import com.cxx.entity.PageBean;
import com.cxx.entity.Student;
import com.cxx.service.StudentService;
import com.cxx.utils.BaseServlet;
import com.cxx.utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/stu")
@MultipartConfig
public class StudentServlet extends BaseServlet {
    StudentService service = new StudentService();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, RuntimeException, IOException {
//        1�������վݵ�map��
        Map<String, String[]> map = req.getParameterMap();
//        2����������
        Student stu = new Student();
//        3��ͨ��BeanUtils��map�е�������ӵ�stu��
        BeanUtils.populate(stu, map);
//        4�����ù������ļ��ϴ�
        String fileName = UploadUtils.uoloadFile(req);
//        5�������ļ���
        stu.setPhoto(fileName);
//        6�����ð���
        stu.setHobby(Arrays.toString(req.getParameterValues("hobby")));
//        7������ҵ��
        int row = service.addStudent(stu);
//        8������ҵ������������Ӧ
        if (row > 0) {
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages");
        } else {
            throw new RuntimeException("���ʧ��");
        }
    }

    /*
     * ��ҳ�������
     * �������� name sex ��ҳ���� currentPage
     * ��ǰҳ  pageSize ÿҳ��ʾ������
     * */
    public void findPages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1�����ܲ���
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
//          �û�ϣ��������ҳ��
        String currentPage = req.getParameter("currentPage");
//        �û�ϣ������������
        String pageSize = req.getParameter("pageSize");
//        2.����ҵ��
        PageBean pb = service.findByPages(name, sex, currentPage, pageSize);
//        3.��pageBean����request��
        req.setAttribute("pb", pb);
        req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
    }

    public void delAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        ���ܲ���
        String sids = req.getParameter("sids");
//        ����ҵ��
        int row = service.delAll(sids);
//         ��Ӧ������
        if (row > 0) {
//            �ض��򵽷�ҳ��ѯ
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages&currentPage=" + req.getParameter("currentPage"));
        } else {
            throw new RuntimeException("����ɾ��ʧ��");
        }
    }

    public void findstudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ��ȡѧ�����
        String sid = req.getParameter("sid");
//        ����ҵ��
        Student stu = service.findStudent(sid);
//        ����������
        req.setAttribute("stu", stu);
//        ����ת����edit.jspҳ��
        req.getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        //        1�������վݵ�map��
        Map<String, String[]> map = req.getParameterMap();
//        2����������
        Student stu = new Student();
//        3��ͨ��BeanUtils��map�е�������ӵ�stu��
        BeanUtils.populate(stu, map);
        //���ð���
        stu.setHobby(Arrays.toString(req.getParameterValues("hobby")));
        //�����ļ�����ȡ�ļ���Դ
        Part part = req.getPart("photo");
        //��ȡ�ļ�����
        String fileName = part.getSubmittedFileName();
        //��ȡ�ϵ��ļ�����
        String oldFileName = req.getParameter("oldFileName");
        if ("".equals(fileName)) {
            //û���ϴ���ͷ��
            stu.setPhoto(oldFileName);
        } else {
            //�ϴ�����ͷ��
            //ɾ�����ļ�
            File file = new File("d:/upload1/" + oldFileName);
            file.delete();//ɾ�����ļ�
            //�ϴ����ļ�
            String newFileName = UploadUtils.uoloadFile(req);
            stu.setPhoto(newFileName);
        }
        //����ҵ��
        int row = service.updateStudent(stu);
        //��Ӧ������
        if (row > 0) {
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages&currentPage");
        } else {
            throw new RuntimeException("�޸�ʧ��");
        }
    }
}
