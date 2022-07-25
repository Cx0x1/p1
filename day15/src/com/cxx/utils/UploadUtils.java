package com.cxx.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    //返回值就是 文件名
    public static String uoloadFile(HttpServletRequest req){
        try {
//            根据文件名获取文件资源
            Part photo = req.getPart("photo");
//            从文件资源中获取文件名称
            String fileName = photo.getSubmittedFileName();
//            从命名文件名
            fileName= UUID.randomUUID()+fileName;
            File file = new File("D:\\ATizi\\upload");
            if (!file.exists()){
//                如果文件夹不存在就创建
                file.mkdir();
            }
            String path = file + "\\" + fileName;
//            将文件输出到该路径下
            photo.write(path);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
