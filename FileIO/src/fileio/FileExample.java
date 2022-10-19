/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        
        //Example1 - Page 2,3
//        File file=new File("C:\\Temp");
//        if(file.isDirectory()){
//            System.out.println("This is folder");
//        }else{
//            System.out.println("This is file");
//        }
//        System.out.println("This is "+(file.isFile()?"File":"Folder"));
        
        //Example2 - Page 4
        File file=new File("C:\\Users\\phung\\Temp");
        System.out.println("This is "+(file.isFile()?"File":"Folder"));
        File[] files=file.listFiles();
        System.out.println("Ten cac file trong folder");
        for(File f:files){
            System.out.println(f.getName());
        }
        System.out.println("HIen thi length cua file(do lon)");
        for(File f:files){
            System.out.println(f.getName()+" : "+f.length()+" bytes");
        }
    }
}
