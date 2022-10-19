package edu.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/upload",name = "fileUpload")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appPath=req.getServletContext().getRealPath("");
        File folder=new File(appPath,"temp");
        if(!folder.exists())folder.mkdir();
        resp.getWriter().println("======="+appPath);
        req.getParts().forEach(part->{
            String name=extractFileName(part);
            byte []buff=new byte[4*1024];
            int read=-1;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(folder,name));
                InputStream inputStream=part.getInputStream();
                while((read=inputStream.read(buff))!=-1){
                    fileOutputStream.write(buff);
                }
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //hien thi thong tin ra screen
        for (Part part:req.getParts()){
            Collection<String> headers=part.getHeaderNames();
            headers.forEach(header->{
                try {
                    resp.getWriter().println(header+" : "+part.getHeader(header));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            resp.getWriter().println("Upload has been done successfully");
        }
    }
    private String extractFileName(Part part){
        String content=part.getHeader("content-disposition");
        Pattern pattern=Pattern.compile(".*filename\\=\"(.*)\".*");
        Matcher matcher=pattern.matcher(content);
        return matcher.matches()? matcher.group(1) : "unknown";
    }
}
