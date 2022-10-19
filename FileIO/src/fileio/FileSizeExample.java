/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author phung
 */
public class FileSizeExample {
    
    //File Size Example 2 - Page 5
//    private static long getSize(File file){
//        if(file.isFile())return file.length();
//        File[]files=file.listFiles();
//        int length=0;
//        for (int i = 0; i < files.length; i++) {
//            if(files[i].isFile()){
//                length+=getSize(files[i]);
//                continue;
//            }
//            length+=files[i].length();
//        }
//        return length;
//    }
    
    //File Size Example 2 Page 6
    private static long getSize(File file){
        if(file.isFile())return file.length();
        AtomicLong length=new AtomicLong(0);
        Arrays.stream(file.listFiles()).forEach(f->{
            length.getAndSet(length.longValue()+(f.isFile()?getSize(f):f.length()));
        });
        return length.longValue();
    }
    
    public static void main(String[] args) {
        File file=new File("C:\\Users\\phung\\Temp");
        System.out.println("Size: "+getSize(file)/(1024*1024)+"MB");
    }
}
