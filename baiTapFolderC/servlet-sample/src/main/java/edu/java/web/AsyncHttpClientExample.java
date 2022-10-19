package edu.java.web;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AsyncHttpClientExample {
    public static void main(String[] args) throws InterruptedException {
       CloseableHttpAsyncClient httpclient= HttpAsyncClients.createDefault();
       httpclient.start();
        HttpGet request=new HttpGet("http://localhost:8080/test/synch");
        httpclient.execute(request, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                try {
                    InputStream stream=response.getEntity().getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                    String line="";
                    while((line=reader.readLine())!=null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void failed(Exception e) {

            }

            @Override
            public void cancelled() {

            }
        });
        int counter=1;
        while(counter<10){
            System.out.println("Main thread is running "+counter);
            Thread.sleep(500);
            counter++;
        }
    }
}
