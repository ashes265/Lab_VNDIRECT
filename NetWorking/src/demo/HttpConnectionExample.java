package demo;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExample {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://www.geeksforgeeks.org/path-resolve-method-in-java-with-examples/");
        URLConnection connection = url.openConnection();
        Path path = Paths.get("test.html");
        try {
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            int read = -1;
            byte[] bytes = new byte[10000000];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,read);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
