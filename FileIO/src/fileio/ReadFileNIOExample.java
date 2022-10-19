/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author phung
 */
public class ReadFileNIOExample {
    public static void main(String[] args) throws IOException {
        //NIO - ReadFile
        FileInputStream fis=null;
        FileChannel fileChannel=null;
        File file=new File("D:\\University\\OJT\\FileIO\\hanoijava.txt");
        try{
            fis=new FileInputStream(file);
            fileChannel=fis.getChannel();
            long size=fileChannel.size();
            ByteBuffer buff=ByteBuffer.allocate((int)size);
            fileChannel.read(buff);
            buff.rewind();
            System.out.println(new String(buff.array(), "utf8"));
        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(fileChannel!=null)fileChannel.close();
            if(fis!=null)fis.close();
        }
    }
}
