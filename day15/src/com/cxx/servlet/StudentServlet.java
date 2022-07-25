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
//        1、解释收据到map中
        Map<String, String[]> map = req.getParameterMap();
//        2、创建对象
        Student stu = new Student();
//        3、通过BeanUtils将map中的数据添加到stu中
        BeanUtils.populate(stu, map);
//        4、调用工具类文件上传
        String fileName = UploadUtils.uoloadFile(req);
//        5、设置文件名
        stu.setPhoto(fileName);
//        6、设置爱好
        stu.setHobby(Arrays.toString(req.getParameterValues("hobby")));
//        7、调用业务
        int row = service.addStudent(stu);
//        8、根据业务处理结果做出响应
        if (row > 0) {
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages");
        } else {
            throw new RuntimeException("添加失败");
        }
    }

    /*
     * 分页组合条件
     * 搜索参数 name sex 分页参数 currentPage
     * 当前页  pageSize 每页显示的条数
     * */
    public void findPages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、接受参数
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
//          用户希望看到的页码
        String currentPage = req.getParameter("currentPage");
//        用户希望看到的条数
        String pageSize = req.getParameter("pageSize");
//        2.调用业务
        PageBean pb = service.findByPages(name, sex, currentPage, pageSize);
//        3.将pageBean放入request域
        req.setAttribute("pb", pb);
        req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
    }

    public void delAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        接受参数
        String sids = req.getParameter("sids");
//        调用业务
        int row = service.delAll(sids);
//         响应处理结果
        if (row > 0) {
//            重定向到分页查询
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages&currentPage=" + req.getParameter("currentPage"));
        } else {
            throw new RuntimeException("批量删除失败");
        }
    }

    public void findstudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取学生编号
        String sid = req.getParameter("sid");
//        调用业务
        Student stu = service.findStudent(sid);
//        存入请求域
        req.setAttribute("stu", stu);
//        请求转发到edit.jsp页面
        req.getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        //        1、解释收据到map中
        Map<String, String[]> map = req.getParameterMap();
//        2、创建对象
        Student stu = new Student();
//        3、通过BeanUtils将map中的数据添加到stu中
        BeanUtils.populate(stu, map);
        //设置爱好
        stu.setHobby(Arrays.toString(req.getParameterValues("hobby")));
        //根据文件名获取文件资源
        Part part = req.getPart("photo");
        //获取文件名称
        String fileName = part.getSubmittedFileName();
        //获取老的文件名称
        String oldFileName = req.getParameter("oldFileName");
        if ("".equals(fileName)) {
            //没有上传新头像
            stu.setPhoto(oldFileName);
        } else {
            //上传了新头像
            //删除老文件
            File file = new File("d:/upload1/" + oldFileName);
            file.delete();//删除老文件
            //上传新文件
            String newFileName = UploadUtils.uoloadFile(req);
            stu.setPhoto(newFileName);
        }
        //调用业务
        int row = service.updateStudent(stu);
        //响应处理结果
        if (row > 0) {
            resp.sendRedirect(req.getContextPath() + "/stu?method=findPages&currentPage");
        } else {
            throw new RuntimeException("修改失败");
        }
    }
}
