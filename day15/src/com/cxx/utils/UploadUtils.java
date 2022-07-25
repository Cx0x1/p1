package com.cxx.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    //����ֵ���� �ļ���
    public static String uoloadFile(HttpServletRequest req){
        try {
//            �����ļ�����ȡ�ļ���Դ
            Part photo = req.getPart("photo");
//            ���ļ���Դ�л�ȡ�ļ�����
            String fileName = photo.getSubmittedFileName();
//            �������ļ���
            fileName= UUID.randomUUID()+fileName;
            File file = new File("D:\\ATizi\\upload");
            if (!file.exists()){
//                ����ļ��в����ھʹ���
                file.mkdir();
            }
            String path = file + "\\" + fileName;
//            ���ļ��������·����
            photo.write(path);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
