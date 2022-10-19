package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author phung
 */
public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        //Output Example - Page 7
//        File file=new File("D:"+File.separator+"University"+File.separator+"OJT"+File.separator+"FileIO"+File.separator+"hanoijava.txt");
//        FileOutputStream fos=null;
//        try{
//            fos=new FileOutputStream(file);
//            byte[]bytes="Hello Ha Noi Java Class".getBytes();
//            fos.write(bytes);
//        }catch(Exception e){
//            System.out.println(e);
//        }finally{
//            if(fos!=null){
//                fos.close();
//            }
//        }

        //Input Example
//        File file=new File("D:"+File.separator+"University"+File.separator+"OJT"+File.separator+"FileIO"+File.separator+"hanoijava.txt");
//        try{
//            FileInputStream fis=new FileInputStream(file);
//            byte[]bytes=new byte[124];
//            fis.read(bytes);
//            System.out.println("["+new String(bytes)+"]");
//        }catch(Exception e){
//            System.out.println(e);
//        }
        
        //Input Example - cont
        File file=new File("D:"+File.separator+"University"+File.separator+"OJT"+File.separator+"FileIO"+File.separator+"hanoijava.txt");
        try{
            FileInputStream fis=new FileInputStream(file);
            byte[]bytes=new byte[4*1024];
            int read=-1;
            StringBuilder builder=new StringBuilder();
            while((read=fis.read(bytes))!=-1){
                builder.append(new String(bytes, 0, read));
            }
            System.out.println("["+builder+"]");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
