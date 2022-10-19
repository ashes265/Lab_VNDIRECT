/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Iterator;
import javafx.scene.shape.Line;

/**
 *
 * @author phung
 */
public class PathExample {

    public static void main(String[] args) throws IOException {
        //Page - 2
        Path path = Paths.get("D:\\University\\OJT\\FileIO\\");
        System.out.println("This is " + (Files.isDirectory(path) ? "File" : "Folder"));
        System.out.println(Files.exists(path));

        //cach2
        try (DirectoryStream<Path> direct = Files.newDirectoryStream(path)) {
            for (Path p : direct) {
                System.out.println(p.getFileName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Page 3\n");
        //Page 3
        DirectoryStream.Filter<Path> filter = new Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };
        
        //chi hien thi folder
//        try (DirectoryStream<Path> direct = Files.newDirectoryStream(path, filter)) {
//            for(Path p:direct){
//                System.out.println(p.getFileName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //filter by pattern
//        try (DirectoryStream<Path> direct = Files.newDirectoryStream(path, "*.{java,txt}")) {
//            for(Path p:direct){
//                System.out.println(p.getFileName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        Path path2=path.resolve("hanoijava.txt");
        
        Charset charset=Charset.forName("utf8");
        try(BufferedReader reader=Files.newBufferedReader(path2,charset)){
            String line=null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
