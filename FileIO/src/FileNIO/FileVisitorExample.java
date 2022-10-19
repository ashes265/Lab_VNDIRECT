/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileNIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 *
 * @author phung
 */
public class FileVisitorExample {

    public static class PrintFiles extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file+" is File!");
//            return super.visitFile(file, attrs); //To change body of generated methods, choose Tools | Templates.
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println(dir+" is directory!");
            return super.postVisitDirectory(dir, exc); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        
    }

    public static void main(String[] args) throws IOException {
        Path path=Paths.get("D:\\University\\OJT\\FileIO\\");
        Files.walkFileTree(path, new PrintFiles());
    }
}
