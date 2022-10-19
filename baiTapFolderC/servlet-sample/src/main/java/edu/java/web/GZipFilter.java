package edu.java.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebFilter(urlPatterns = "/html")
public class GZipFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("\n Destroy filter!\n");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("\n Destroy filter!\n");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String encoding=request.getHeader("Accept-Encoding");
        if(encoding!=null && encoding.indexOf("gzip")>-1){
            response.addHeader("Content-Encoding", "gzip");
            GZipServletResponseWrapper gzipResponse= new GZipServletResponseWrapper(response);
            filterChain.doFilter(servletRequest,gzipResponse);
            gzipResponse.close();
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
