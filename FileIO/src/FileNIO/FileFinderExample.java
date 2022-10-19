/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileNIO;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;

public class FileFinderExample {

    public static class Finder extends SimpleFileVisitor<Path> {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(matcher.matches(file.getFileName())){
                System.out.println("Found "+ file.getFileName());
            }
            return FileVisitResult.CONTINUE; //To change body of generated methods, choose Tools | Templates.
        }
    }

    public static void main(String[] args) throws IOException {
        Path path=Paths.get("D:\\University\\OJT\\FileIO\\", args);
        Files.walkFileTree(path, new Finder());
    }
}
