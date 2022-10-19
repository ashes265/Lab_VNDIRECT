/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileNIO;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

/**
 *
 * @author phung
 */
public class RandomAccessFileExample {

    public static void main(String[] args) {
        
        //Page - 6
        Path path = Paths.get("D:\\University\\OJT\\FileIO\\hanoijava.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1);
        try (FileChannel fc = FileChannel.open(path, READ, WRITE)) {
//            fc.read(buffer);
            fc.position(0);
            byte[]bytes="Tran".getBytes();
            fc.write(ByteBuffer.wrap(bytes));
//            System.out.println(new String(buffer.array()));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
