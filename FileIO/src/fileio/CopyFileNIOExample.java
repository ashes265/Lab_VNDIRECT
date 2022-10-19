/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author phung
 */
public class CopyFileNIOExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File sourceFile = new File("D:\\University\\OJT\\FileIO\\io_sample.txt");
        File desFile =new File("D:\\University\\OJT\\FileIO\\io_sample2.txt");
        FileChannel srcChannel=null;
        FileChannel desChannel=null;
        srcChannel=new FileInputStream(sourceFile).getChannel();
        desChannel=new FileOutputStream(desFile).getChannel();
        srcChannel.transferTo(0, srcChannel.size(), desChannel);
        Desktop.getDesktop().open(sourceFile.getParentFile());
    }
}
