package edu.java.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientExample {
    public static void main(String[] args) throws InterruptedException {
//        try{
//            URL url=new URL("http://localhost:8080/test/html");
//            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.addRequestProperty("Accept-Encoding","gzip");
//            int responseCode= connection.getResponseCode();
//            System.out.println("Response Code: "+responseCode);
//            BufferedReader reader;
//            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line="";
//            while((line=reader.readLine())!=null){
//                System.out.println(line);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        ExecutorService executor= Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url=new URL("http://localhost:8080/test/html");
                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.addRequestProperty("Accept-Encoding","gzip");
                    BufferedReader reader;
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line="";
                    while((line=reader.readLine())!=null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        executor.shutdown();
        Thread.sleep(5000);
    }
}
