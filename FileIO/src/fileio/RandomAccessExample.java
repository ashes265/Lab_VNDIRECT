package fileio;

import java.awt.Desktop;
import java.io.File;
import java.io.RandomAccessFile;
import static java.rmi.server.ObjID.read;


public class RandomAccessExample {
    public static void main(String[] args) {
        //Page 10
        File file=new File("D:\\University\\OJT\\FileIO\\io_sample.txt");
        try(RandomAccessFile randomAccess=new RandomAccessFile(file, "rw")){
            randomAccess.seek(0);
            byte[]bytes=new byte[4*102];
            int read=randomAccess.read(bytes);
            System.out.println(new String(bytes, 0, read, "utf8"));
            
            randomAccess.seek(file.length());
//            randomAccess.write("\r\n".getBytes());
//            randomAccess.writeChars("Hello Co Can");
            
            Desktop.getDesktop().open(file);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
