/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ReaderWriterExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file=new File("D:\\University\\OJT\\FileIO\\io_sample.txt");
        try(FileWriter writer=new FileWriter(file, true)){
            writer.write("\r\n");
            writer.write("Tran Thi B");
            Desktop.getDesktop().open(file);
        }catch(Exception e){
            System.out.println(e);
        }
        FileReader reader=null;
        reader=new FileReader(file);
        char[]buffer=new char[4*1024];
        int read=-1;
        StringBuilder builder=new StringBuilder();
        while((read=reader.read(buffer))!=-1){
            builder.append(buffer,0,read);
        }
        System.out.println(builder);
        System.out.println();
    }
}
