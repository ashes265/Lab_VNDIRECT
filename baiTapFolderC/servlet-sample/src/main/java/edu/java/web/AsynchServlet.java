package edu.java.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(urlPatterns = "/synch", asyncSupported = true)
public class AsynchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext ctx=req.startAsync();
        ctx.setTimeout(60*1000);
        ctx.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3*1000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Writer writer=ctx.getResponse().getWriter();
                    URL url=new URL("https://www.google.com.vn/");
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.addRequestProperty("Accept-Encoding","gzip");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line="";
                    while((line=reader.readLine())!=null){
                        writer.write(line);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ctx.complete();
            }
        });
    }
}
