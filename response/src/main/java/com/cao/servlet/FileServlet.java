package com.cao.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author admin_cg
 * @data 2020/10/5 18:01
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = "F:\\java\\javaweb-02-servlet\\response\\target\\classes\\1.png";
        System.out.println("下载文件路径：" + realPath);
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);

        FileInputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();

        while ((len = in.read(buffer)) > 0){
            outputStream.write(buffer, 0, len);
        }
        in.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
