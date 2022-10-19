package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class URLConnectionExample {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url=new URL("https://www.geeksforgeeks.org/");
        URLConnection connection =url.openConnection();
        InputStream stream=connection.getInputStream();
        int read=-1;
        byte[]bytes=new byte[1000];
        while((read=stream.read(bytes))!=-1){
            System.out.println(new String(bytes, 0, read));
        }
    }
}
