/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author phung
 */
public class HttpHeaderExample {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url=new URL("https://www.geeksforgeeks.org/");
        HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
        System.out.println("Http Method "+connection.getRequestMethod());
        Map<String,List<String>> headers=connection.getHeaderFields();
        BiConsumer<String,List<String>>header=(key,values)->{
            System.out.println("Key "+key+" Values "+values);
        };
        headers.forEach(header);
        
    }
}
