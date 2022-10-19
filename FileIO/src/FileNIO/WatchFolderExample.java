/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileNIO;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.attribute.BasicFileAttributes;

public class WatchFolderExample {

    public static void watch(Path path) {
        FileSystem fs = path.getFileSystem();
        try (WatchService service = fs.newWatchService()) {
            path.register(service, ENTRY_CREATE);
            while (true) {
                WatchKey key = service.take();
                for(WatchEvent watchEnvent : key.pollEvents()){
                    WatchEvent.Kind kind=watchEnvent.kind();
                    if(ENTRY_CREATE==kind){
                        Path newPath=((WatchEvent<Path>)watchEnvent).context();
                        System.out.println("New path created: "+newPath);
                    }
                }
                if (!key.reset()) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("D:\\University\\OJT\\FileIO\\");
        watch(path);
    }
}
