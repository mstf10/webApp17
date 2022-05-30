/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet(name = "fileupload", urlPatterns = {"/fileupload"})
public class FileUpload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        if (req.getPart("file").getSubmittedFileName().endsWith(".txt")) {
            InputStream inputStream = req.getPart("file").getInputStream();
            byte[] asd = inputStream.readAllBytes();
            String asd2 = new String(asd);
            out.println(req.getPart("file").getContentType());
            out.println(req.getPart("file").getHeaderNames());
            out.println(req.getPart("file").getName());

        }else{
              out.println("txt uzantılı dosya yüklemelisiniz!");
        }

    }

}
